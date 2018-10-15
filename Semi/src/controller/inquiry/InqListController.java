package controller.inquiry;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.board.Inquiry;
import service.board.InquiryService;
import service.board.InquiryServiceImpl;
import utils.Paging;



@WebServlet("/inquiry/list")
public class InqListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private InquiryService inquiryService = new InquiryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		//----- ����¡ �۾� -----
		// ���� ������ ��ȣ ���
		int curPage = inquiryService.getCurPage(req);

		// ����¡ ��ü
		int totalCount = inquiryService.getTotalCount();

		Paging paging = new Paging(totalCount, curPage,10); 

		// List�� ��ȸ ��� ���
		List<Inquiry> list = inquiryService.getPagingList(paging);

		// ��û�� ��� ��Ƽ� ������
		req.setAttribute("inquirylist", list);

		// ����¡ ��ü �𵨷� �߰� �ϱ�
		req.setAttribute("paging", paging);

		// ������ ȭ�� ����
		req.getRequestDispatcher("").forward(req, resp);
		
		

	}
}
