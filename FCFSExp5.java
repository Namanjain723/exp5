import java.util.*;

class Process {
    int pid;         // Process ID
    int arrivalTime; // Arrival time
    int burstTime;   // Burst timec
    int completionTime; // Completion time
    int waitingTime;    // Waiting time
    int turnAroundTime; // Turnaround time

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
}

public class FCFSExp5 {

    public static void main(String[] args) {
        System.gc();

        // Hardcoded input: List of processes (Process ID, Arrival Time, Burst Time)
        List<Process> processes = new ArrayList<>();

        processes.add(new Process(1, 1, 4)); 
        processes.add(new Process(2, 3, 2)); 
        processes.add(new Process(3, 4, 3)); 
        processes.add(new Process(4, 6, 9)); 
        processes.add(new Process(5, 7, 2)); 

        // Sort processes by arrival time
        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0;
        double totalWaitingTime = 0, totalTurnAroundTime = 0;

        // Calculate waiting time, turnaround time and completion time for each process
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime; // Wait until process arrives
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnAroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnAroundTime - p.burstTime;

            currentTime = p.completionTime;

            totalWaitingTime += p.waitingTime;
            totalTurnAroundTime += p.turnAroundTime;
        }

        // Print process details
        System.out.println("PID\tArrival\tBurst\tCompletion\tWaiting\tTurnaround");
        for (Process p : processes) {
            System.out.println(p.pid + "\t" + p.arrivalTime + "\t" + p.burstTime + "\t" + p.completionTime + "\t\t" + p.waitingTime + "\t" + p.turnAroundTime);
        }

        System.out.printf("\nAverage Waiting Time: %.2f\n", (totalWaitingTime / processes.size()));
        System.out.printf("Average Turnaround Time: %.2f\n", (totalTurnAroundTime / processes.size()));

        System.gc();
    }
}
