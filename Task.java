

import java.util.*;
 class Schedule  {
	int deadline = 0;
	int min = 0;
	int done = 0;

	Schedule(int deadline, int min) {
		this.deadline = deadline;
		this.min = min;
	}
}





public class Task {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Number of task :");
		int n = scanner.nextInt();
		int max = 0;
		ArrayList<Schedule> sch = new ArrayList<Schedule>();
		for (int i = 0; i < n; i++) {
			System.out.println("Enter deadline :");
			int deadline = scanner.nextInt();
			System.out.println("Need of task :");
		         int min = scanner.nextInt();
			Schedule schedule = new Schedule(deadline, min);
			int j = i - 1;
			while (j >= 0 && sch.get(j).deadline > schedule.deadline) {
				Schedule schedule1 = sch.get(j);
				schedule1.done += schedule.min;
				max = Math.max(max, schedule1.done - schedule1.deadline);
				j--;
			}
			sch.add(j + 1, schedule);
			if (j < 0)
				schedule.done = schedule.min;
			else
				schedule.done = sch.get(j).done + schedule.min;
			max = Math.max(max, schedule.done - schedule.deadline);
			System.out.println(max);
		}
	}
}
