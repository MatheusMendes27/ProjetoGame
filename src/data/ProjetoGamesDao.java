package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProjetoGamesDao {
    
    Connection con;
    PreparedStatement pstm;
    ResultSet rs;
    ProjetoGames pg = new ProjetoGames(); 

    public boolean connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "1234");
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public int insert(ProjetoGames pg) {
       int status;
        try {
            pstm = con.prepareStatement("INSERT into game_manage VALUES(?,?,?,?,?)");
            pstm.setString(1, pg.getCodigo());
            pstm.setString(2, pg.getNome());
            pstm.setString(3, pg.getDesenvolvedora());
            pstm.setString(4, pg.getPlataforma());
            pstm.setDouble(5, pg.getValor());
            
            status= pstm.executeUpdate();
            
            return status;
        } 
        
        catch (SQLException ex) {
            return ex.getErrorCode();
        }
        
      }
    
    public ProjetoGames consultar (String codigo)
   {
       try 
       {
           
           pstm = con.prepareStatement("SELECT * FROM game_manage WHERE codigo = ?"); 
           pstm.setString(1,codigo);
           
           rs = pstm.executeQuery();  
           
           
           if(rs.next())
           {
               pg.setCodigo(rs.getString("codigo")); 
               pg.setNome(rs.getString("nome"));
               pg.setDesenvolvedora(rs.getString("dev"));
               pg.setPlataforma(rs.getString("plataforma"));
               pg.setValor(rs.getDouble("valor"));
               return pg;
           }
           else
           {
               return null;
           }
       }
       
       catch (SQLException ex) 
       {
           return null;
       }
    }
    
    
    public boolean atualizar(ProjetoGames pg){
        try {
            pstm = con.prepareStatement("UPDATE game_manage SET nome=?, dev=?, plataforma=?, valor=? WHERE codigo = ?");
            pstm.setString(1, pg.getNome());
            pstm.setString(2, pg.getDesenvolvedora());
            pstm.setString(3, pg.getPlataforma());
            pstm.setDouble(4, pg.getValor());
            pstm.setString(5, pg.getCodigo());
            pstm.executeUpdate();
            return true;
        } 
        catch (SQLException ex) {
          return false;
        }
        
    }
    
       public boolean excluir (String codigo)
     {
       try {
          
           pstm = con.prepareStatement("DELETE FROM game_manage WHERE codigo = ?");
           pstm.setString(1, codigo);
           pstm.executeUpdate();
           return true;
       } catch (SQLException ex) {
           return false;    
       }
   }
    public void desconectar()
   {
       try {
           con.close();
       } catch (SQLException ex) {
         
       }
   }
}
