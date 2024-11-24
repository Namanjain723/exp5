public class Exp5FCFSwoA {

    static class Process {
        int pid; // Process ID
        int burstTime; // Burst time of process
        int completionTime; // Completion time of process
        int waitingTime; // Waiting time of process
        int turnaroundTime; // Turnaround time of process

        public Process(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
        }
    }

    public static void main(String[] args) {
        // Define 5 hardcoded processes with burst times only
        Process[] processes = {
            new Process(1, 5),
            new Process(2, 3),
            new Process(3, 8),
            new Process(4, 6),
            new Process(5, 4)
        };

        int n = processes.length; // Number of processes
        int currentTime = 0; // Tracks the current time

        // Calculate completion, waiting, and turnaround times
        for (Process p : processes) {
            // Completion time is current time plus burst time
            p.completionTime = currentTime + p.burstTime;
            // Turnaround time is completion time since all processes arrive at time 0
            p.turnaroundTime = p.completionTime;
            // Waiting time is turnaround time minus burst time
            p.waitingTime = p.turnaroundTime - p.burstTime;
            // Update current time
            currentTime = p.completionTime;
        }

        // Display the results
        System.out.println("PID\tBurst\tCompletion\tWaiting\tTurnaround");
        for (Process p : processes) {
            System.out.println(p.pid + "\t" + p.burstTime + "\t" +
                               p.completionTime + "\t\t" + p.waitingTime + "\t" + p.turnaroundTime);
        }

        // Calculate and display average waiting time and turnaround time
        double avgWaitingTime = 0, avgTurnaroundTime = 0;
        for (Process p : processes) {
            avgWaitingTime += p.waitingTime;
            avgTurnaroundTime += p.turnaroundTime;
        }
        System.out.println("\nAverage Waiting Time: " + (avgWaitingTime / n));
        System.out.println("Average Turnaround Time: " + (avgTurnaroundTime / n));
    }
}
