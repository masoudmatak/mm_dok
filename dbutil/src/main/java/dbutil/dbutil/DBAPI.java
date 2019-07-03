/*
Owner and programmer: Masoud Mohammadi 2019
Copywrite is limited and it is only the owner of the program code
can allow the use of it in a system if legal overcoming occurs. 
All rights are reserved for the owner of the code.
This is part of a system design and implementation of this 
Document Management System is based on a particular application area. 
This implementation is based on observation of the use in certain industries. 
In the case of copyright infringement, the owner is entitled to legal 
action and will require legal action through court.
*/
package dbutil.dbutil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



import dbutil.dbutil.model.Doc;
import dbutil.dbutil.model.MetaData;
import dbutil.dbutil.model.YtaAndVarumarke;

public class DBAPI {

	private static String LIMIT_CLAUSE = " limit 200";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static boolean validate(String user, String password) {
		Connection con = null;
		PreparedStatement ps = null;

		try {
			
			ps = ConnectionMgmt.getConnection().prepareStatement("Select uname, password from users where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} finally {
			//DataConnect.close(con);
		}
		return false;
	}
	
	public static List<YtaAndVarumarke> getDocYta(String loginUser) {
		System.out.println("Personnummer: " + loginUser);
		List<YtaAndVarumarke> lista = new ArrayList<YtaAndVarumarke>();
		try {
			Statement st = ConnectionMgmt.getConnection().createStatement();
			String sql = "select ad_id, yta, varumarke, texten from mm_user_adgroup where personnummer='" + loginUser
					+ "'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				YtaAndVarumarke inf = new YtaAndVarumarke();
				inf.setYta(rs.getString("ad_id"));
				inf.setYta(rs.getString("yta"));
				inf.setVarumarke(rs.getString("varumarke"));
				inf.setTextBeskrivning(rs.getString("texten"));
				lista.add(inf);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("SQL FEL: " + e);
		}
		return null;
	}

	public static List<Doc> getDocdata() {
		System.out.println("getDocdata()  is invoked...............");
		List<Doc> lista = new ArrayList<Doc>();
		String sql = "select id,doktype, year, color,docsize, sold, personnummer, skadenummer,customerid,varumarke,sekundar_varumarke,"
				+ " bucket_name,document_class,source_systemid,filename, time_inserted, bucket_name from doc order by time_inserted limit 1";
		try {
			Statement st = ConnectionMgmt.getConnection().createStatement();

			System.out.println("getDocdata() : " + sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Doc inf = new Doc();
				inf.setId(rs.getString("id"));
				inf.setDoktype(rs.getString("doktype"));
				inf.setYear(rs.getInt("year"));
				inf.setColor(rs.getString("color"));
				inf.setDocsize(rs.getInt("docsize"));
				inf.setSold(rs.getBoolean("sold"));
				inf.setPersonnummer(rs.getString("personnummer"));
				inf.setSkadenummer(rs.getString("skadenummer"));
				inf.setCustomerid(rs.getString("customerid"));
				inf.setFilename(rs.getString("filename"));
				inf.setVarumarke(rs.getString("varumarke"));
				inf.setSekundar_varumarke(rs.getString("sekundar_varumarke"));
				inf.setBucket_name(rs.getString("bucket_name"));
				inf.setDocument_class(rs.getString("document_class"));
				inf.setSource_systemid(rs.getString("source_systemid"));
				inf.setTime_inserted(rs.getTimestamp("time_inserted"));
				inf.setBucket_name(rs.getString("bucket_name"));
				/*
				 * inf.setGallrings_date(rs.getTimestamp("gallrings_date"));
				 * 
				 * 
				 */

				lista.add(inf);
			}
			return lista;
		} catch (Exception e) {
			System.out.println(" getDocdata()  SQL FEL: " + sql + e);
		}
		return null;
	}

	public static List<Doc> getMetadata() {
		System.out.println("getMetadata()  is invoked...............");
		List<Doc> lista = new ArrayList<Doc>();
		try {
			Statement st = ConnectionMgmt.getConnection().createStatement();
		/*	String sql = "select id,name,filename,document_class,document_type,time_inserted,updated_time,source_systemid,personnummer,"
					+ " customerid,skadenummer,sourcesystem_name,policy_number,handledare_name,department,varumarke,sekundar_varumarke,gallringstyp_nr,"
					+ " gallrings_date,owner_id,yta,dokid from mm_document order by id " + LIMIT_CLAUSE;
			*/
			
			String sql = "select id,filename,document_class,doktype,time_inserted,source_systemid,personnummer,"+
			" customerid,skadenummer,varumarke,sekundar_varumarke, "+
			" gallrings_date,generated_filename,bucket_name from doc order by time_inserted desc " + LIMIT_CLAUSE;
			
			System.out.println("MM: " + sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Doc inf = new Doc();
				inf.setId(rs.getString("id"));
				inf.setGenerated_filename(rs.getString("generated_filename"));
				inf.setFilename(rs.getString("filename"));
				inf.setDocument_class(rs.getString("document_class"));
				inf.setCustomerid(rs.getString("customerid"));
				inf.setTime_inserted(rs.getTimestamp("time_inserted"));
				inf.setVarumarke(rs.getString("varumarke"));
				inf.setSkadenummer(rs.getString("skadenummer"));
				inf.setDoktype(rs.getString("doktype"));
				inf.setPersonnummer(rs.getString("personnummer"));
				inf.setBucket_name(rs.getString("bucket_name"));
				inf.setSource_systemid(rs.getString("source_systemid"));
				lista.add(inf);
			}
			return lista;
		} catch (Exception e) {
			System.out.println("SQL FEL: " + e);
		}
		return null;
	}

	private void getFromDB(String personnummer) {
		System.out.println("Personnummer: " + personnummer);

		try {
			Statement st = ConnectionMgmt.getConnection().createStatement();
			String sql = "select name,filename,document_class,source_systemid,personnummer,skadenummer,policy_number,varumarke,department,customerid"
					+ " from mm_document where personnummer='" + personnummer + "'";

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {

			}

		} catch (Exception e) {
			System.out.println("SQL FEL: " + e);
		}

	}

	public static List<String> getAllAdgroup() {
		System.out.println(" getAllAdgroup()  is invoked...............");
		List<String> lista = new ArrayList<String>();
		try {
			Statement st = ConnectionMgmt.getConnection().createStatement();
			String sql = "select name from mm_ad_group order by name";
			System.out.println("getAllAdgroup: " + sql);

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				lista.add(rs.getString("name"));
			}
			return lista;
		} catch (Exception e) {
			System.out.println("SQL FEL: " + e);
		}
		return null;
	}

	public static void insertIntoDB(String dokName, String fileName, String document_class, String source_systemid,
			String personnummer, String skadenummer, String policy_number, String varumarke, String department,
			String customerid, String yta, String gallringdagar, String sourcesystem_name, String which_year) {
		try {

			System.out.println("nya anropas....................................");
			PreparedStatement ps = ConnectionMgmt.getConnection().prepareStatement(
					"insert into doc(filename,document_class,source_systemid,personnummer,skadenummer,varumarke,"
							+ " customerid, year, doktype,color,bucket_name,generated_filename) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			System.out.println("before : " + ps.toString());

			ps.setString(1, fileName);
			ps.setString(2, document_class);
			ps.setString(3, source_systemid);
			ps.setString(4, personnummer);
			ps.setString(5, skadenummer);
			ps.setString(6, varumarke);
			ps.setString(7, customerid);
			
			ps.setString(8, which_year);
			ps.setString(9, document_class);
			ps.setString(10, "Black");
			ps.setString(11, document_class);
			ps.setString(12, dokName);

			System.out.println("After : " + ps.toString());
			
			
			int i = ps.executeUpdate();
			if (i > 0) {
				// System.out.println("File are successfully registered into DB...");
			}
		} catch (Exception e) {
			System.out.println(document_class);
			System.out.println("SQL FEL: " + " docclass==" + document_class + " " + e);
		}
	}

	public static void IntoDBORG(String dokName, String fileName, String document_class, String source_systemid,
			String personnummer, String skadenummer, String policy_number, String varumarke, String department,
			String customerid, String yta, String gallringdagar, String sourcesystem_name) {
		try {
			PreparedStatement ps = ConnectionMgmt.getConnection().prepareStatement(
					"insert into mm_document(name,filename,document_class,source_systemid,personnummer,skadenummer,policy_number,varumarke,"
							+ " department,customerid,yta,gallrings_date,sourcesystem_name) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, dokName);
			ps.setString(2, fileName);
			ps.setString(3, document_class);
			ps.setString(4, source_systemid);
			ps.setString(5, personnummer);
			ps.setString(6, skadenummer);
			ps.setString(7, policy_number);
			ps.setString(8, varumarke);
			ps.setString(9, department);
			ps.setString(10, customerid);
			ps.setString(11, yta);

			int gallringInt = Integer.parseInt(gallringdagar);

			Timestamp timestamp = new Timestamp(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * gallringInt));
			// System.out.println("insertIntoDB says................ " + timestamp);
			ps.setTimestamp(12, timestamp);
			ps.setString(13, sourcesystem_name);
			int i = ps.executeUpdate();
			if (i > 0) {
				// System.out.println("File are successfully registered into DB...");
			}
		} catch (Exception e) {
			System.out.println(document_class);
			System.out.println("SQL FEL: " + " docclass==" + document_class + " " + e);
		}
	}

	public static boolean insertMasoud(String userName, String passwd, String email, String language) {
		try {

			PreparedStatement ps = ConnectionMgmt.getConnection()
					.prepareStatement("insert into masoud(userName,password,email,language) values(?,?,?,?)");

			ps.setString(1, userName);
			ps.setString(2, passwd);
			ps.setString(3, email);
			ps.setString(4, language);

			int i = ps.executeUpdate();
			return true;

		} catch (Exception e2) {
			System.out.println(e2);
		}
		return false;
	}

	public String getAdgroup(String user_string) {

		// tabel mm_user_adgroup
		String adgroup = "";
		try {
			PreparedStatement ps = ConnectionMgmt.getConnection()
					.prepareStatement("select ad_id from  mm_user_adgroup where ad_id= ?");
			ps.setString(1, user_string);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				adgroup = rs.getString("ad_id");
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return adgroup;
	}

	public static List<MetaData> getDocments(String user_string) {

		List<MetaData> lista = new ArrayList<MetaData>();
		try {
			PreparedStatement ps = ConnectionMgmt.getConnection().prepareStatement(
					"select id,name,filename,document_class,customerid,time_inserted,varumarke,skadenummer,yta,personnummer from mm_document where document_class in(select docclass from mm_dok.mm_adgrpup_docclass where ad_id in (SELECT ad_id FROM mm_dok.mm_user_adgroup where user_string=?))");
			ps.setString(1, user_string);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				MetaData inf = new MetaData();
				inf.setId(rs.getInt("id"));
				inf.setName(rs.getString("name"));
				inf.setFilename(rs.getString("filename"));
				inf.setDocument_class(rs.getString("document_class"));
				inf.setCustomerid(rs.getString("customerid"));
				inf.setTime_inserted(rs.getTimestamp("time_inserted"));
				inf.setVarumarke(rs.getString("varumarke"));
				inf.setSkadenummer(rs.getString("skadenummer"));
				inf.setYta(rs.getString("yta"));
				inf.setPersonnummer(rs.getString("personnummer"));
				inf.setDokid(rs.getString("dokid"));

				inf.setSource_systemid(rs.getString("source_systemid"));

				inf.setTime_inserted(rs.getTimestamp("time_inserted"));
				lista.add(inf);
			}
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return lista;
	}

	public static List<Doc> searchDocs(String personnummer, String skadenummer) {

		List<Doc> lista = new ArrayList<Doc>();
		try {

			if (personnummer == null && skadenummer==null) {
				return lista;
			}
			Statement st = ConnectionMgmt.getConnection().createStatement();
			String sql="";
			if (skadenummer != null && !skadenummer.equalsIgnoreCase("")) {
				sql = "select id,doktype, year, color,docsize, sold, personnummer, skadenummer,customerid,varumarke,sekundar_varumarke,bucket_name,document_class,source_systemid,"
						+ " filename, time_inserted, bucket_name from doc where personnummer like '" + personnummer
						+ "%'  and skadenummer like '" + skadenummer + "%'" + LIMIT_CLAUSE;
				System.out.println(sql);
			} else if(skadenummer==null || skadenummer.equalsIgnoreCase("")) {
				sql = "select id,doktype, year, color,docsize, sold, personnummer, skadenummer,customerid,varumarke,sekundar_varumarke,"
						+ " bucket_name,document_class,source_systemid,filename, time_inserted, bucket_name from doc where personnummer like '"
						+ personnummer + "%'"+ LIMIT_CLAUSE;
			}
			System.out.println("searchDokument "+sql);

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {

				Doc inf = new Doc();
				inf.setId(rs.getString("id"));
				inf.setDoktype(rs.getString("doktype"));
				inf.setYear(rs.getInt("year"));
				inf.setColor(rs.getString("color"));
				inf.setDocsize(rs.getInt("docsize"));
				inf.setSold(rs.getBoolean("sold"));
				inf.setPersonnummer(rs.getString("personnummer"));
				inf.setSkadenummer(rs.getString("skadenummer"));
				inf.setCustomerid(rs.getString("customerid"));
				inf.setFilename(rs.getString("filename"));
				inf.setVarumarke(rs.getString("varumarke"));
				inf.setSekundar_varumarke(rs.getString("sekundar_varumarke"));
				inf.setBucket_name(rs.getString("bucket_name"));
				inf.setDocument_class(rs.getString("document_class"));
				inf.setSource_systemid(rs.getString("source_systemid"));
				inf.setTime_inserted(rs.getTimestamp("time_inserted"));
				//inf.setBucket_name(rs.getString("bucket_name"));
				//System.out.println("search doc gav skadenummer:..........................." + inf.getSkadenummer());
				lista.add(inf);
			}
			System.out.println("Result size "+lista.size());
		} catch (Exception e2) {
			System.out.println(e2);
		}
		return lista;
	}

	/*
	 * select * from mm_document where document_class in (select docclass from
	 * mm_dok.mm_adgrpup_docclass where ad_id in (SELECT ad_id FROM
	 * okmdb.mm_user_adgroup where user_string='MNAS33'))
	 */
}
