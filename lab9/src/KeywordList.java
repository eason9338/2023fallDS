import java.util.ArrayList;

public class KeywordList
{
	private ArrayList<Keyword> lst;

	public KeywordList()
	{
		this.lst = new ArrayList<Keyword>();
	}

	public void add(Keyword keyword)
	{
		lst.add(keyword);
	}

	public void sort()
	{
		if (lst.size() == 0)
		{
			System.out.println("InvalidOperation");
		}
		else
		{
			quickSort(0, lst.size() - 1);
		}
	}

	// YOUR TURN
	// 1. Implement QuickSort algorithm
	// We assume that you are using an in-place approach, hence the return type is
	// void. If you prefer to use a different approach, you can modify this return
	// type (e.g., change it to return ArrayList<Keyword>)
	private void quickSort(int leftbound, int rightbound)
	{
		int j = leftbound;
		int k = rightbound - 1;
		if(k <= j){
			return;
		}
		int pivot = lst.get(rightbound).count;

		int debug = 0;
		while(j < k) {
			if(lst.get(j).count > lst.get(k).count) {
				swap(j, k);
			}

			if(lst.get(j).count <= pivot){
				j++;
			}
			else if(lst.get(k).count > pivot) {
				k--;
			}
			//1, 5, 2, 3, p=4
			//1, 3, 2, 5, p=4

			debug ++;
			if(debug >= 10) {
				System.out.println("Infinite loop");
				return;
			}
		}
		swap(j, rightbound);
		//1, 3, 2, 5, 4, p=2
		quickSort(leftbound, j-1);
		quickSort(j, rightbound);
	}

	private void swap(int aIndex, int bIndex)
	{
		Keyword temp = lst.get(aIndex);
		lst.set(aIndex, lst.get(bIndex));
		lst.set(bIndex, temp);
	}

	public void output()
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < lst.size(); i++)
		{
			Keyword k = lst.get(i);
			if (i > 0)
				sb.append(" ");
			sb.append(k.toString());
		}

		System.out.println(sb.toString());
	}
}