package controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Notice;
import service.board.NoticeService;
import service.board.NoticeServiceImpl;


@WebServlet("/notice/view")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeService noticeService = new NoticeServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// �Ķ���� �޾ƿ��� 
		Notice notice = noticeService.getParam(req, resp);

		// �Խù� �󼼺���
		notice = noticeService.view(notice);

		// ���� �𵨿� ��� ����
		req.setAttribute("notice", notice);
		
		// ������ ȭ�� ����
		req.getRequestDispatcher("").forward(req, resp);
	}
}
