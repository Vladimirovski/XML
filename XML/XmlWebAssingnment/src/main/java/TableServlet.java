import cars.CarType;
import cars.CarsType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class TableServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance("cars");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
          //  File file = new File("C:\\Users\\HP\\IdeaProjects\\XmlWebAssingnment\\src\\main\\xml\\cars.xml")
          //  Source source = new StreamSource(file);
            File file = new File("C:\\Users\\win 10\\IdeaProjects\\XmlWebAssingnment\\src\\main\\xml\\cars.xml");
            Source source = new StreamSource(file);
            JAXBElement<CarsType> root = unmarshaller.unmarshal(source, CarsType.class);
            CarsType carsType = root.getValue();
            List<CarType>types = carsType.getCar();





           req.setAttribute("carList", types);


           req.getRequestDispatcher("/carsTable.jsp").forward(req, resp);

        } catch (JAXBException e) {
            e.printStackTrace();
        }



    }
}
