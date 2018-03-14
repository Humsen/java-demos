package pers.husen.log4j;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Log4jServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		String prefix = config.getServletContext().getRealPath("/");
		System.out.println("***********" + prefix);

		String configFile = config.getInitParameter("log4jConfig");
		System.out.println(configFile);

		String filePath = prefix + configFile;
		System.out.println(filePath);

		try {
			String xmlFilePath = "C:\\Program Files (x64)\\DevTools\\apache-tomcat-8.5.16\\wtpwebapps\\web_log4j\\config\\log4j2.xml";
			String logsParentDir = "F:\\workspace\\workspace pers\\web_log4j\\logs";

			File file = new File(xmlFilePath);
			// 1.得到DOM解析器的工厂实例
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			// 2.从DOM工厂里获取DOM解析器
			DocumentBuilder db = dbf.newDocumentBuilder();
			// 3.解析XML文档，得到document，即DOM树
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			// 直接获取该节点
			Node node = doc.getElementsByTagName("Property").item(0);
			// 获取当前节点值
			String currentValue = node.getTextContent();
			System.out.println("当前值：" + currentValue);
			node.setTextContent(logsParentDir);
			String currentValue1 = node.getTextContent();
			System.out.println("修改后：" + currentValue1);

			// 保存读取的XML为DOM树
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource domSource = new DOMSource(doc);
			StreamResult result = new StreamResult(new FileOutputStream(xmlFilePath));
			// 把DOM树转换为xml文件
			transformer.transform(domSource, result);

			// 实例化logger
			// Logger logger = LogManager.getLogger(Log4j2ConfigServlet.class.getName());
			// logger.info("log4j logs path config, path :" + logsParentDir);
		} catch (Exception e) {
			// Logger logger = LogManager.getLogger(Log4j2ConfigServlet.class.getName());
			// logger.error(e);
		}

		File file = new File(prefix);
		String strParentDirectory = file.getParent();
		System.out.println("文件的上级目录为 : " + strParentDirectory);
		Log4jInit.testLog4j(filePath);
	}
}