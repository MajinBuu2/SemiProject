package dao.board;

import java.util.List;

import dto.board.InqFile;
import dto.board.Inquiry;



public interface InqFileDao {


	// ���� ���ε� ���� �Է� 
	public void insert(InqFile file);
	
	// ���� ����Ʈ 
	public List<InqFile> list();
	
	// ���Ϲ�ȣ�� ���� ���
	public InqFile selectByFileno(InqFile file);
	
	// ���� ��ȣ�� ���� ��������
	public InqFile selectByInqIdx(Inquiry inq);

	// ���� ����� 
	public void delete(InqFile file);
}
