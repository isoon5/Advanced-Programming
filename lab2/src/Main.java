public class Main {

        public static void main(String args[])
        {
            Problem pb = new Problem();



            //initializare vehicule
            Car car =new Car("car");


            //initializare depouri
            Depot depou1 = new Depot("D1");
            Vehicle[] theVehicles1 = {car};
            depou1.setVehicles(theVehicles1);

            Depot depou2 = new Depot("D2");
            depou1.setVehicles(theVehicles1);

            //initializare clienti
            Client c1= new Client("C1",1);
            Client c2= new Client("C2",1);
            Client c3= new Client("C3",2);
            Client c4= new Client("C4",2);
            Client c5= new Client("C5",2);

            //integrare depouri
            Depot[] depouri = new Depot[]{depou1, depou2};
            pb.setDepots(depouri);
            //integrare clienti
            Client[] listaClienti = new Client[] {c1, c2, c3, c4, c5};
            pb.setClients(listaClienti);


            //setare fortata solutie


            Tour sol1= new Tour();
            car.setDepot(depou1);
            sol1.setVehicles(car);
            Client[] listaClienti2 = new Client[] {c1, c3, c5};
            sol1.setClients(listaClienti2);

            Client[] listaClienti4 = new Client[] {c4};
            Tour sol3 = new Tour();
            sol3.setClients(listaClienti4);

            Tour sol2 = new Tour();
            Tour[] solutie = new Tour[] {sol1, sol2, sol3};

            pb.setSolution(solutie);
            System.out.println(pb.toString());

        }



    }

}
