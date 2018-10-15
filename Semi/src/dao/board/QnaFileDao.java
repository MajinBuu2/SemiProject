package dao.board;

import java.util.List;

import dto.board.QnaFile;


public interface QnaFileDao {


	// ���� ���ε� ���� �Է� 
	public void insert(QnaFile file);
	
	// ���� ����Ʈ 
	public List<QnaFile> list();
	
	// ���Ϲ�ȣ�� ���� ���
	public QnaFile selectByFileno(int fileno);

	// ���� ����� 
	public void delete(QnaFile file);
}
