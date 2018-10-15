package dao.board;

import java.util.List;

import dto.board.Qna;
import utils.Paging;

public interface QnaDao {

		// Qna ��ü ����¡�Ͽ� ����Ʈ�� ��ȸ 
		public List<Qna> selectPagingList(Paging paging);
		
		// ��ü �Խñ� �� ��ȸ
		public int selectCntAll() ;
			
		// Qna_idx�� �ϳ��� Qna ��ȸ�ϱ�
		public Qna selectInqByInqIdx (Qna qna);
		
		// ��ȸ�� ��ȸ�� �ø���
		public void updateHit(Qna qna);
		
		// �Խù� ��� �ϱ�
		public void insert(Qna qna);
		
		// �Խù� ���� �ϱ�
		public void delete(Qna qna);
		
		// �Խù� ���� �ϱ�
		public void update(Qna qna);
}
