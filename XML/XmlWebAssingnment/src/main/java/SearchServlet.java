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
import java.util.stream.Collectors;

public class SearchServlet extends HttpServlet {
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

            File file = new File("C:\\Users\\win 10\\IdeaProjects\\XmlWebAssingnment\\src\\main\\xml\\cars.xml");
            Source source = new StreamSource(file);
            JAXBElement<CarsType> root = unmarshaller.unmarshal(source, CarsType.class);
            CarsType carsType = root.getValue();


            String manufacturer = req.getParameter("cars");
            String yearStart = req.getParameter("from");
            String yearEnd = req.getParameter("to");
            String fuel = req.getParameter("fuel");

            List<CarType> types=null;

            if ( manufacturer.isEmpty() && yearStart.isEmpty() && yearEnd.isEmpty() && fuel.isEmpty()) {
                req.getRequestDispatcher("/carsTable.jsp").forward(req, resp);
            }

            if ( !manufacturer.isEmpty() && !yearStart.isEmpty()&&!yearEnd.isEmpty()&&!fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).filter(carType -> carType.getConsumption().getType().equals(fuel)).collect(Collectors.toList());

            }




            if ( !manufacturer.isEmpty() && yearStart.isEmpty()&&yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && !yearStart.isEmpty()&&yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && yearStart.isEmpty()&&!yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && yearStart.isEmpty()&&yearEnd.isEmpty()&&!fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> carType.getConsumption().getType().equals(fuel)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && !yearStart.isEmpty()&&!yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && !yearStart.isEmpty()&&yearEnd.isEmpty()&&!fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).filter(carType -> carType.getConsumption().getType().equals(fuel)).collect(Collectors.toList());

            }
            if ( !manufacturer.isEmpty() && yearStart.isEmpty()&&!yearEnd.isEmpty()&&!fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> carType.getManufacturer().equals(manufacturer)).filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).filter(carType -> carType.getConsumption().getType().equals(fuel)).collect(Collectors.toList());

            }





            if ( manufacturer.isEmpty() && !yearStart.isEmpty()&&yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).collect(Collectors.toList());

            }

            if ( manufacturer.isEmpty() && !yearStart.isEmpty()&&!yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> Integer.parseInt(carType.getProductionYear())>=Integer.parseInt(yearStart)).filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).collect(Collectors.toList());

            }
            if ( manufacturer.isEmpty() && !yearStart.isEmpty()&&yearEnd.isEmpty()&&!fuel.isEmpty()) {
                types = carsType.getCar();

                types.removeIf(c ->  c.getConsumption().getType() == null);
                types.removeIf((carType -> Integer.parseInt(carType.getProductionYear())<Integer.parseInt(yearStart)));
                types.removeIf(carType -> !carType.getConsumption().getType().equals(fuel));
            }

            if ( manufacturer.isEmpty() && !yearStart.isEmpty()&&!yearEnd.isEmpty()&&!fuel.isEmpty()) {

                types = carsType.getCar();

                types.removeIf(c ->  c.getConsumption().getType() == null);
                types.removeIf(carType -> !carType.getConsumption().getType().equals(fuel));
                types.removeIf((carType -> Integer.parseInt(carType.getProductionYear())<Integer.parseInt(yearStart)));
                types.removeIf(carType -> Integer.parseInt(carType.getProductionYear())>Integer.parseInt(yearEnd));

            }




            if ( manufacturer.isEmpty() && yearStart.isEmpty()&&!yearEnd.isEmpty()&&fuel.isEmpty()) {
                types = carsType.getCar().stream().filter(carType -> Integer.parseInt(carType.getProductionYear())<=Integer.parseInt(yearEnd)).collect(Collectors.toList());

            }

            if ( manufacturer.isEmpty() && yearStart.isEmpty() && !yearEnd.isEmpty() && !fuel.isEmpty()) {
                types = carsType.getCar();

                types.removeIf(c ->  c.getConsumption().getType() == null);
                types.removeIf(carType -> !carType.getConsumption().getType().equals(fuel));
                types.removeIf(carType -> Integer.parseInt(carType.getProductionYear())>Integer.parseInt(yearEnd));

            }




            if ( manufacturer.isEmpty() && yearStart.isEmpty()&&yearEnd.isEmpty()&&!fuel.isEmpty()) {

                types = carsType.getCar();

                types.removeIf(c ->  c.getConsumption().getType() == null);
                types.removeIf(carType -> !carType.getConsumption().getType().equals(fuel));


            }

            req.setAttribute("list", types);


            req.getRequestDispatcher("/carsTable.jsp").forward(req, resp);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }


}