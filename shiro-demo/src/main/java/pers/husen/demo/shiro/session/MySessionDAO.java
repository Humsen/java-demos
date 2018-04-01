package pers.husen.demo.shiro.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.springframework.jdbc.core.JdbcTemplate;

import pers.husen.demo.shiro.utils.JdbcTemplateUtils;
import pers.husen.demo.shiro.utils.SerializableUtils;

import java.io.Serializable;
import java.util.List;

public class MySessionDAO extends CachingSessionDAO {

	private JdbcTemplate jdbcTemplate = JdbcTemplateUtils.jdbcTemplate();

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId = generateSessionId(session);
		assignSessionId(session, sessionId);
		String sql = "insert into sessions(id, session) values(?,?)";
		jdbcTemplate.update(sql, sessionId, SerializableUtils.serialize(session));
		return session.getId();
	}

	@Override
	protected void doUpdate(Session session) {
		if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
			return; // 如果会话过期/停止 没必要再更新了
		}
		String sql = "update sessions set session=? where id=?";
		jdbcTemplate.update(sql, SerializableUtils.serialize(session), session.getId());
	}

	@Override
	protected void doDelete(Session session) {
		String sql = "delete from sessions where id=?";
		jdbcTemplate.update(sql, session.getId());
	}

	@Override
	protected Session doReadSession(Serializable sessionId) {
		String sql = "select session from sessions where id=?";
		List<String> sessionStrList = jdbcTemplate.queryForList(sql, String.class, sessionId);
		if (sessionStrList.size() == 0)
			return null;
		return SerializableUtils.deserialize(sessionStrList.get(0));
	}
}