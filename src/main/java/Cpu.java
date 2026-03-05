/**
 * This record will store an entry of a CPU, where the values entered will be kept for calculation later.
 *
 * @param name is the model name of the CPU that will be stored, e.g. Intel Core i7 7700
 * @param generation is the generation of the CPU, e.g. Intel 7th Generation would be 7
 * @param cores is the number of cores that the stored CPU has, e.g. i7 7700 has 4 cores
 * @param threads is the number of threads that the stored CPU has, e.g. i7 7700 has 8 threads
 * @param boostClockSpeed is the clockspeed (in MHz) that the stored CPU can run at, e.g. i7 7700 runs @ 4200Mhz
 * @param fabProcess is the size of the transistors in the CPU's, e.g. i7 7700 uses a 14nm fabProcess
 *
 */

public record Cpu(String name, Integer generation, Integer cores, Integer threads, Integer boostClockSpeed, Integer fabProcess) {
}
