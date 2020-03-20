import java.util.Arrays;

public class Problem {
    public Depot[] getDepots(){
        return depots;
    }
    public void setDepots(Depot[] depots){
        this.depots = depots;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    private Depot[] depots;
    private Client[] clients;

    private Tour[] solution;

    public Tour[] getSolution() {
        return solution;
    }

    public void setSolution(Tour[] solution) {
        this.solution = solution;

        public String toString() {

            StringBuilder sol = new StringBuilder();
            sol.append( "Solutie: \n");

            for(int i= 0 ;i< solution.length; i++)
            {
                sol.append( solution[i].getVehicle().getName() + ": ");
                sol.append( solution[i].getVehicle().getDepot().getName());

                for(int j=0; j< solution[i].getClients().length;j++)
                {
                    Client[] clientList = solution[i].getClients() ;
                    sol.append(" -> " + clientList[j].getName());
                }

                sol.append( " -> " + solution[i].getVehicle().getDepot().getName());
                sol.append("\n");

            }

            return  sol.toString();
        }
}
