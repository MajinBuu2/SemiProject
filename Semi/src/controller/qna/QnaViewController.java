package controller.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Qna;
import service.board.QnaService;
import service.board.QnaServiceImpl;



@WebServlet("/qna/view")
public class QnaViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnaService qnaService = new QnaServiceImpl();
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");

		// �Ķ���� �ޱ� 
		Qna qna = qnaService.getParam(req, resp);

		// �Խù� �� ����
		qna = qnaService.view(qna);

		// ���� ����
		req.setAttribute("qna", qna);
		
		
		req.getRequestDispatcher("").forward(req, resp);
	}
}
