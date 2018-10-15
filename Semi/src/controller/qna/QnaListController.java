package controller.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.board.QnaDao;
import dao.board.QnaDaoImpl;
import dto.board.Qna;
import service.board.QnaService;
import service.board.QnaServiceImpl;
import utils.Paging;



@WebServlet("/qna/list")
public class QnaListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private QnaService qnaService = new QnaServiceImpl();
	private QnaDao qnaDao = new QnaDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//----- ����¡ �۾� -----
		// ���� ������ ��ȣ ���
		int curPage = qnaService.getCurPage(req);
		
		// ����¡ ��ü
		int totalCount = qnaService.getTotalCount();
		
		Paging paging = new Paging(totalCount, curPage,10); 
		
		// List�� ��ȸ ��� ���
		List<Qna> list = qnaService.getPagingList(paging);
		
		// ��û�� ��� ��Ƽ� ������
		req.setAttribute("qnalist", list);
		
		// ����¡ ��ü �𵨷� �߰� �ϱ�
		req.setAttribute("paging", paging);
		
		// ������ ȭ�� ����
		req.getRequestDispatcher("").forward(req, resp);
		
		
	}
}


































