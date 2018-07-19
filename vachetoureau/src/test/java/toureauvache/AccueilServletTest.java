package toureauvache;
import fr.m2i.poec.toureauvache.servlet.AccueilServlet;
import junit.framework.TestCase;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import static org.mockito.Mockito.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.mockito.Mockito;

public class AccueilServletTest extends Mockito{
	AccueilServlet as = new AccueilServlet();
	public void test1() throws ServletException, IOException {
		HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("proposition")).thenReturn("proposition");
        when(request.getParameter("envoyer")).thenReturn("envoyer");
        when(request.getParameter("recommencer")).thenReturn("recommencer");
        
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);

			when(response.getWriter()).thenReturn(writer);



        new AccueilServlet().doPost(request, response);

        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("proposition"));
		
	}
}
