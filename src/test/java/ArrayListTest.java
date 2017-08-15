import java.util.ArrayList;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ArrayListTest {
	
	public static ArrayList<String> fifthHarmony;
	
	@Before
	public void setUp() {
		fifthHarmony = new ArrayList<String>();
	}

	@After
	public void tearDown() {
		fifthHarmony.clear();
	}

	@Test
	public void AddSingerTest(){ //Test Add(E element)
		//Adicionando uma integrante
		fifthHarmony.add("Lauren");
		Assert.assertFalse(fifthHarmony.isEmpty());
		Assert.assertTrue(fifthHarmony.size()==1);
		Assert.assertEquals("Cantora inserida com sucesso","Lauren",fifthHarmony.get(0));
		
		//Adicionando um membro nulo
		fifthHarmony.add(null);
		Assert.assertTrue(fifthHarmony.size()==2);
		Assert.assertEquals("Null inserido", null, fifthHarmony.get(1)); 	
		
		//Adicionando uma string vazia
		fifthHarmony.add("");
		Assert.assertTrue(fifthHarmony.size()==3);
		Assert.assertEquals("Vazio inserido","",fifthHarmony.get(2));	
	}
	
	@Test
	public void AddSingerPositionTest(){ //Test Add(int index, E element)
		//Testando valores negativos
		try{
			fifthHarmony.add(-1, "Camila Cabello");
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando os limites positivos
		try{
			fifthHarmony.add(Integer.MAX_VALUE, "Camila Cabello");
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando valores extremamente pequenos
		try{
			fifthHarmony.add(Integer.MIN_VALUE, "Camila Cabello");			
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando index zero
		fifthHarmony.add(0, "Camila Cabello");
		Assert.assertTrue(fifthHarmony.size()==1);
		Assert.assertEquals("Camila Cabello adicionada ao grupo","Camila Cabello",fifthHarmony.get(0));
		fifthHarmony.remove(0);		
	}
	
	@Test
	public void ClearGroup(){ //Test Clear()
			
			fifthHarmony.clear();
			Assert.assertTrue(fifthHarmony.size()==0);
			
			fifthHarmony.add(null);
			Assert.assertFalse(fifthHarmony.size()==0);
			fifthHarmony.clear();

			fifthHarmony.add(0,"Lauren Jauregui");
			fifthHarmony.add(1,"Ally Brooke");
			fifthHarmony.add(2,"Normani Kordey");
			fifthHarmony.add(3,"Dinah Janne");
			fifthHarmony.add(4,"Camila Cabello");
			fifthHarmony.clear();
			Assert.assertEquals("O grupo acabou!", 0,fifthHarmony.size());
	}
	
	@Test
	public void ContainsGroup(){ //Test contains(Object o)
		fifthHarmony.add("Ally");
		Assert.assertTrue(fifthHarmony.contains("Ally"));
		Assert.assertEquals("Ally está contida no grupo","Ally",fifthHarmony.get(0));
		fifthHarmony.remove(0);
		
		fifthHarmony.add(null);
		Assert.assertTrue(fifthHarmony.contains(null));
		Assert.assertEquals("Nulo está contido no grupo",null,fifthHarmony.get(0));
		fifthHarmony.remove(0);
		
		fifthHarmony.add("");
		Assert.assertTrue(fifthHarmony.contains(""));
		Assert.assertEquals("Vazio está contido no grupo","",fifthHarmony.get(0));
		fifthHarmony.remove(0);
		
		Assert.assertFalse("Nulo não está presente antes dos demais",fifthHarmony.contains(null));	
	}
	
	@Test
	public void getGroup(){ //Test get(int index)		
		fifthHarmony.add(0,"Lauren Jauregui");
		fifthHarmony.add(1,"Ally Brooke");
		fifthHarmony.add(2,"Normani Kordey");
		fifthHarmony.add(3,"Dinah Janne");
		fifthHarmony.add(4,"Camila Cabello");
		
		//Testando valores negativos
		try{
			fifthHarmony.get(-1);
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando os valores extremamente grandes
		try{
			fifthHarmony.get(Integer.MAX_VALUE);
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando os limites positivos
		try{
			fifthHarmony.get(5);
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Testando valores extremamente pequenos
		try{
			fifthHarmony.get(Integer.MIN_VALUE);			
		}catch(IndexOutOfBoundsException e){
			
		}
		
		//Verificando o método Get
		Assert.assertEquals("Pegando a Camila do grupo","Camila Cabello",fifthHarmony.get(4));
		Assert.assertEquals("Pegando a Lauren do grupo","Lauren Jauregui",fifthHarmony.get(0));
	}
	
	@Test
	public void isEmptyGroup(){ // Test isEmpty()
		Assert.assertTrue(fifthHarmony.isEmpty());
		fifthHarmony.add("Dinah Jane");
		Assert.assertFalse(fifthHarmony.isEmpty());
		fifthHarmony.remove(0);
		Assert.assertTrue(fifthHarmony.isEmpty());
	}
	
	@Test
	public void removeMemberPosition(){ //Test remove(int index)
		fifthHarmony.add(0,"Camila Cabello");
		Assert.assertTrue(fifthHarmony.size()==1);
		fifthHarmony.remove(0);
		Assert.assertFalse(fifthHarmony.size()==1);
		try{
			Assert.assertNotEquals("Camila foi removida do grupo com sucesso","Camila Cabello",fifthHarmony.get(0));
		}catch(IndexOutOfBoundsException e){
			
		}
	}
	
	@Test
	public void removeMember(){ // Test remove(Object o)		
		fifthHarmony.add(0,"Lauren Jauregui");
		fifthHarmony.add(1,"Ally Brooke");
		fifthHarmony.add(2,"Normani Kordey");
		fifthHarmony.add(3,"Dinah Janne");
		fifthHarmony.add(4,"Camila Cabello");
		
		fifthHarmony.remove((String) "Lauren Jauregui");
		Assert.assertEquals("A primeira integrante agora é Ally Brooke","Ally Brooke",fifthHarmony.get(0));
		Assert.assertTrue(fifthHarmony.size()==4);
		Assert.assertFalse(fifthHarmony.contains((String) "Lauren Jauregui"));
		
		Assert.assertFalse(fifthHarmony.remove(null));
		
	}
	
	@Test
	public void SizeGroup(){ //Test size()
		Assert.assertTrue(fifthHarmony.size()==0);
		Assert.assertFalse(fifthHarmony.size()==-1);
	}
}
