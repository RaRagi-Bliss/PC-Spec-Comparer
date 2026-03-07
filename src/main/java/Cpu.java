//import org.junit.assert.*
/**
 * This record will store an entry of a CPU, where the values entered will be kept for calculation later, or can be done within the record.
 *
 * @param cpuModel is the model name of the CPU that will be stored, e.g. Intel Core i7 7700
 * @param generation is the generation of the CPU, e.g. Intel 7th Generation would be 7
 * @param cores is the number of cores that the stored CPU has, e.g. i7 7700 has 4 cores
 * @param threads is the number of threads that the stored CPU has, e.g. i7 7700 has 8 threads
 * @param boostClockSpeed is the clockspeed (in MHz) that the stored CPU can run at, e.g. i7 7700 runs @ 4200Mhz
 * @param fabProcess is the size of the transistors in the CPU's, e.g. i7 7700 uses a 14nm fabProcess
 *
 */

public record Cpu(String cpuModel, int generation, int cores, int threads, int boostClockSpeed, int fabProcess) {
    /**
     * The formula used to calculate the CPU performance score will be processed in this record and returned
     *
     * @return returns the total score from the CPU in a float.
     */
    public Cpu{
        //Assertions.assertTrue(threads >= cores,"Cannot have more cores than threads");
    }
    public float totalScore(){
        //todo fine tune the combination of hyperThreadBonus and ageNegator
        return hyperThreadBonus() * ageNegator();
        //return 0;
    }

    /**
     * hyperThreadBonus() calculates how many of the CPU's cores are single threaded
     * and how many are multithreaded (if any). Once calculated,
     * @return uses a ternary operator to either return the number of cores there are in the CPU (if it is single threaded)
     *  or returns the performant equivalent number of single threaded cores in the system.
     *  e.g. Core i7 7700 has 4 cores, 8 threads, and so would have a performance equivalent of 5.2 single threaded cores.
     */
    private float hyperThreadBonus(){
        int hyperThreadedCores = threads - cores;
        int singleThreadCores = cores - hyperThreadedCores;
        return (hyperThreadedCores > 0) ? (1.3f * hyperThreadedCores) + singleThreadCores : singleThreadCores;
    }

    /**
     * ageNegator() increases or decreases the performance bias of a CPU depending on its age and process node (how small
     * the CPUs transistors are). The smaller the process nodes and newer the CPU is, the higher performance bias, as well
     * as the latter.
     * @return gives the output of the CPU age bias formula
     */
    float ageNegator(){
        //ToDo return a solution that returns a multiplier for the CPU's age and fabrication process
        //  This formula only plays nicely with Intel CPUs for now, earlier AMD CPUs are negatively biased from this
        //  Stage solution would be to check if it's an AMD or Intel, and + to the generation number to match Intel's
        //  generation naming scheme?
        return (float) (Math.sqrt(generation) / Math.sqrt(fabProcess));
    }
}
