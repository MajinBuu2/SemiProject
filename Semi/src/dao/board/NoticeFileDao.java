package dao.board;

import java.util.List;

import dto.board.NoticeFile;


public interface NoticeFileDao {


	// ���� ���ε� ���� �Է� 
	public void insert(NoticeFile file);
	
	// ���� ����Ʈ 
	public List<NoticeFile> list();
	
	// ���Ϲ�ȣ�� ���� ���
	public NoticeFile selectByFileno(int fileno);

	// ���� ����� 
	public void delete(NoticeFile file);
}
