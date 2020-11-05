
package Modelo;

import Entidades.Camp;
import Entidades.DetalleCampaña;
import Entidades.Revendedora;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class DetalleCampData {
    
    private Connection con;
    
    public DetalleCampData(Conexion conexion){
        this.con=conexion.getConection();
    }
    
    public void nuevaSuscripcion(DetalleCampaña dc){
       String sql="INSERT INTO detallecampaña(idCamp, idRevendedora) VALUES (?,?)";
       try{
           PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           ps.setInt(1,dc.getCamp().getIdCamp());
           ps.setInt(2,dc.getRevendedora().getIdRevendedora());
           ps.executeUpdate();
           ResultSet rs=ps.getGeneratedKeys();
           if(rs.next()){
           dc.setIdDetCamp(rs.getInt("idDetCamp"));
           }else{
               JOptionPane.showMessageDialog(null,"No se encontro el ID");
           }
          
           
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "No se pudo efectuar la suscripcion");
       }
    }
    
}
