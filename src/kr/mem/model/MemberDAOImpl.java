package kr.mem.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDAOImpl implements MemberDAO{
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public void getConnect() {
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dbClose() {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//crud
	@Override
	public List<MemberVO> memberList() {
		//VO(묶고) -> List(담고)
		String SQL = " SELECT * FROM memiot ";
		List<MemberVO> list = new ArrayList<MemberVO>();
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String mname = rs.getString("mname");
				int mage = rs.getInt("mage");
				String memail = rs.getString("memail");
				String mtel = rs.getString("mtel");
				MemberVO vo = new MemberVO(num, id, pass, mname, mage, memail, mtel);
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public int memberInsert(MemberVO vo) {
		//받고 저장
		int cnt = -1; //실패의 의미로 -1 을 사용
		String SQL = " INSERT INTO memiot VALUES (num_seq.nextval, ?, ?, ?, ?, ?, ?) ";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getPass());
			ps.setString(3, vo.getMname());
			ps.setInt(4, vo.getMage());
			ps.setString(5, vo.getMemail());
			ps.setString(6, vo.getMtel());
			cnt = ps.executeUpdate(); //실행
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public int memberDelete(int num) {
		//삭제
		int cnt = 01;
		String SQL = " DELETE FROM memiot WHERE num = ? ";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			cnt = ps.executeUpdate(); //실행
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public MemberVO memberContent(int num) {
		String SQL = " SELECT * FROM memiot WHERE num = ? ";
		MemberVO vo = null;
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				String id = rs.getString("id");
				String pass = rs.getString("pass");
				String mname = rs.getString("mname");
				int mage = rs.getInt("mage");
				String memail = rs.getString("memail");
				String mtel = rs.getString("mtel");
				vo = new MemberVO(num, id, pass, mname, mage, memail, mtel);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		//수정
		int cnt = -1; //실패의 의미로 -1 을 사용
		String SQL = " UPDATE memiot SET mage = ?, memail = ?, mtel = ? WHERE num = ? ";
		getConnect();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, vo.getMage());
			ps.setString(2, vo.getMemail());
			ps.setString(3, vo.getMtel());
			ps.setInt(4, vo.getNum());
			cnt = ps.executeUpdate(); //실행
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
}
