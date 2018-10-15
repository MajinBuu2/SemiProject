package controller.inquiry;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.board.InqFileDao;
import dao.board.InqFileDaoImpl;
import dto.board.InqFile;
import dto.board.Inquiry;
import service.board.InquiryService;
import service.board.InquiryServiceImpl;




@WebServlet("/inquiry/write")
public class InqWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InquiryService inquiryService = new InquiryServiceImpl();
	private Inquiry inquiry = new Inquiry();
	private InqFile file = new InqFile();
	private InqFileDao inqfileDao = new InqFileDaoImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ���ڵ� ����
		req.setCharacterEncoding("utf-8");
	
		// ���ǿ��� �α��� ���� Ȯ���� �� ���� ����
		
		// ������ ������ ���� 
		req.getRequestDispatcher("").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");

	
		//--- MultipartRequest �������� �Ű� ���� �غ�---
		// 1. ��û ��ü 
		//	���� ���� �ʿ� ���� 
		
		// 2. ���� ���� ��ġ
		// String ���� ������ ���� ��� ���� 
		
		// 3. ���ε� ���� ������ 
		
		// 4. ���ڵ� 
		// ���ε� ���� ���ڵ� ��� 
		
		
		// 5. �ߺ� ���� �̸� ��å
		// DefaultFileRenamePolicy �� �ߺ������� ������ 
		// ���� �̸� �ڿ� ���ڸ� �߰��ϰ� 1���� ������Ų��. 
		
		//-----------------------------------------------
		
		// MultipartRequest ��ü ���� 
		// ���� ���ε� ó�� 
		
		
		inquiryService.write(inquiry);
		
		inquiryService.insertFile(file);
		


		// ������ ȭ�� ����
		resp.sendRedirect("");
	
	
	}
}
