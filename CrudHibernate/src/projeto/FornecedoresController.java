package projeto;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class FornecedoresController {
    
	EntityManager em = new ConnectionFactory().getConnection();
        
        public Fornecedores findById(Integer id){
            
            EntityManager em = new ConnectionFactory().getConnection();
            Fornecedores fornecedores = null;
            
            try{
               fornecedores = em.find(Fornecedores.class, id);
            }catch (Exception e){
                System.err.println(e);
            }finally{
                em.close();
            }
            
            return fornecedores;
        }
        
        public List<Fornecedores> findAll(){
            
            EntityManager em = new ConnectionFactory().getConnection();
            List<Fornecedores> fornecedores = null;
            
            try{
                
                fornecedores = em.createQuery("from Fornecedores f").getResultList();
                
            }catch(Exception e){
                System.err.println(e);
            }finally{
                em.close();
            }
            
            return fornecedores;
            
        }
	
	public void salvar(Fornecedores _fornecedores) {
		em.getTransaction().begin();
		em.merge(_fornecedores);
		em.getTransaction().commit();
		em.close();
	}
        
        public void alterar(Fornecedores _fornecedores){
            em.getTransaction().begin();
            em.merge(_fornecedores);
            em.getTransaction().commit();;
            em.close();
        }
	
	public Fornecedores remove(Integer id){
            
            EntityManager em = new ConnectionFactory().getConnection();
            Fornecedores fornecedores = null;
            
            try{
                
                fornecedores = em.find(Fornecedores.class, id);
                em.getTransaction().begin();
                em.remove(fornecedores);
                em.getTransaction().commit();
                
            }catch(Exception e){
                System.err.println(e);
                em.getTransaction().rollback();
            }finally{
                em.close();
            }
            
            return fornecedores;
            
        }
    
}
