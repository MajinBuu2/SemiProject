package dao.board;

import java.util.List;

import dto.board.Inquiry;
import utils.Paging;



public interface InquiryDao {
	
	// Inquiry ��ü ����¡�Ͽ� ����Ʈ�� ��ȸ 
	public List<Inquiry> selectPagingList(Paging paging);
	
	// ��ü �Խñ� �� ��ȸ
	public int selectCntAll() ;
		
	// Inq_idx�� �ϳ��� Inquiry ��ȸ�ϱ�
	public Inquiry selectInqByInqIdx (Inquiry inq);
	
	// ��ȸ�� ��ȸ�� �ø���
	public void updateHit(Inquiry inq);
	
	// �Խù� ��� �ϱ�
	public void insert(Inquiry inq);
	
	// �Խù� ���� �ϱ�
	public void delete(Inquiry inq);
	
	// �Խù� ���� �ϱ�
	public void update(Inquiry inq);
	
	// �亯 �ȵ� �Խñ� ��ȸ 
	public List<Inquiry> selectInqByAnswer();
}
