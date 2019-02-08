package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fr.pizzeria.dao.PizzaMemDao;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class DaoTest {
	PizzaMemDao dao;
	
	@Before
	public void setUp() throws Exception {
		
		dao = new PizzaMemDao();
	}

	@After
	public void tearDown() throws Exception {

		dao.findAllPizzas();
		
	}

	@Test
	public void testAjoutPizza() throws SavePizzaException {
		assertTrue("Dao doit être vide", dao.findAllPizzas().isEmpty());
		
		//On ajoute une pizza
		dao.saveNewPizza(new Pizza("PEP", "Pert", 10));
		
		//On vérifie que la pizza est bien dans le dao
		assertTrue("J'ai trouvé ma pizza", dao.findPizzaByCode("PEP").getCode().equals("PEP"));
	}

	@Test
	public void testModifiePizza() throws SavePizzaException, UpdatePizzaException{
		
		//On ajoute une pizza
		Pizza pizza = new Pizza("PEP", "Pert", 10);
		dao.saveNewPizza(pizza);

		assertFalse("Dao ne doit pas être vide", dao.findAllPizzas().isEmpty());

		assertTrue("J'ai trouvé ma pizza", dao.findPizzaByCode("PEP").getCode().equals("PEP"));

		//On modifie une pizza
		pizza.setCode("PAP");
		pizza.setLibelle("autre");
		pizza.setPrix(15);

		//On met à jour la pizza
		dao.updatePizza("PEP", pizza);

		//On verifie que la pizza a été bien modifier
		assertTrue("J'ai modifié ma pizza", dao.findPizzaByCode("PAP").getCode().equals("PAP"));
	}

	@Test
	public void testSupprimePizza() throws SavePizzaException, DeletePizzaException{
		
		//On ajoute une pizza
		Pizza pizza = new Pizza("PEP", "Pert", 10);
		dao.saveNewPizza(pizza);
		
		assertTrue("J'ai trouvé ma pizza", dao.findPizzaByCode("PEP").getCode().equals("PEP"));
		
		//Suppression de la pizza
		dao.deletePizza("PEP");
		
		assertTrue("Dao doit être vide", dao.findAllPizzas().isEmpty());
	}
}
