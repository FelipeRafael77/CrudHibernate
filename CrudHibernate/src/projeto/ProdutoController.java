package projeto;

import connection.ConnectionFactory;
import java.util.List;
import javax.persistence.EntityManager;

public class ProdutoController {
    
             EntityManager em = new ConnectionFactory().getConnection();
             
             public Produto findById(Integer id){
            
            EntityManager em = new ConnectionFactory().getConnection();
            Produto produto = null;
            
            try{
               produto = em.find(Produto.class, id);
            }catch (Exception e){
                System.err.println(e);
            }finally{
                em.close();
            }
            
            return produto;
        }
        
        public List<Produto> findAll(){
            
            EntityManager em = new ConnectionFactory().getConnection();
            List<Produto> produto = null;
            
            try{
                
                produto = em.createQuery("from Produto p").getResultList();
                
            }catch(Exception e){
                System.err.println(e);
            }finally{
                em.close();
            }
            
            return produto;
            
        }
	
                public void salvar(Produto _produto) {
		em.getTransaction().begin();
		em.merge(_produto);
		em.getTransaction().commit();
		em.close();
	}
                
                   public void alterar(Produto _produto) {

        em.getTransaction().begin();
        em.merge(_produto);
        em.getTransaction().commit();;
        em.close();
    }
	
	public Produto remove(Integer id){
            
            EntityManager em = new ConnectionFactory().getConnection();
            Produto produto = null;
            
            try{
                
                produto = em.find(Produto.class, id);
                em.getTransaction().begin();
                em.remove(produto);
                em.getTransaction().commit();
                
            }catch(Exception e){
                System.err.println(e);
                em.getTransaction().rollback();
            }finally{
                em.close();
            }
            
            return produto;
            
        }
    
}
