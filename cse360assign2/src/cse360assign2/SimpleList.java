// Name:		Joshua Norris
// Class ID:	366
// Assignment:	1
// Description:	Adds and removes elements in an integer list, returns the integers as a string, and keeps track
//				of the number of elements in the list


package cse360assign2;

/* Class which contains the private variables list and count, the public constructor SimpleList, and
 * the public methods add, remove, count, toString, and search.
 * The list and count values are modified and/or accessed in every method.
 * list holds an array of integers.
 * count is an integer
 */
public class SimpleList 
{
	private int[] list;
	private int count;
	
	/* Constructor for the SimpleList class.
	 * list is defined as an integer array of size 10.
	 * count is given an initial value of 0.
	 */
	public SimpleList()
	{
		this.list = new int[10];
		this.count = 0;
	}
	
	/* Adds a given element into the array at index 0.
	 * Any values already in the array are shifted one place to the right by traversing from right to left
	 * through the array.
	 * If the array is already full before the element is added, the size of the array in increased by 50%.
	 * The given element is inserted into index 0 in all situations.
	 * The integer index is used to traverse the array from right to left.
	 */
	public void add(int element)
	{
		if (count == this.list.length)	//Increase size and add element if full
		{
			int[] tempList = new int[(int) (count * 1.5)]; //New array of increase size
			for (int index = count - 1; index > 0; index--) //Shift and copy elements to bigger array
				tempList[index] = list[index - 1];
			this.list = new int[(int) (count * 1.5)]; //Have list be bigger array
			for (int index = 1; index < count; index++) //Copy elements back into list
				this.list[index] = tempList[index];
		}
		else if (count > 0)
		{
			for (int index = count; index > 0; index--)
				list[index] = list[index - 1];
		}
		list[0] = element;
		count++;
	}
	
	/* Removes a given element from the array if it exists in the array.
	 * The integer array newList is used to hold the values of list without the removed value.
	 * All elements except the given element to be removed are copied from list to newList.
	 * All elements of newList are then copied back into newList.
	 * The integer index is used to traverse list from left to right.
	 * The integer newIndex is used to traverse newList from left to right since values in list may be skipped.
	 */
	public void remove(int element)
	{
		int[] newList = new int[10]; //New array with removed elements
		int newIndex = 0; //Index for newList, prevents empty cells in the new array
		for (int index = 0; index < count; index++)
		{
			if (list[index] == element)
			{
				newList[newIndex] = list[++index]; //Skip copying the item to be removed and increase index
				count--;
			}
			else
			{
				newList[newIndex] = list[index];
			}
			newIndex++;
		}
		for (int index = 0; index < count; index++)
		{
			list[index] = newList[index];	//Copy the newList back into the original list
		}
	}
	
	// Returns the value of count
	public int count()
	{
		return count;
	}
	
	/* Stores the values of the array into a string separated by spaces and returned the string
	 * result hold the string of the values of the array
	 * index is used to traverse the array from left to right
	 * There is a space after each number except for the last
	 * result is returned
	 */
	public String toString()
	{
		String result = "";
		for (int index = 0; index < count; index++)
		{
			if (index == count - 1)
				result += list[index];
			else
				result += list[index] + " ";
		}
		return result;
	}
	
	/* Searches for a given element and returns the index
	 * result is defaulted to -1 and takes the index value if the element is found
	 * index is used to traverse the array from left to right
	 * result is returned
	 */
	public int search(int element)
	{
		int result = -1;
		for (int index = 0; index < count; index++)
		{
			if(list[index] == element)
				result = index;
		}
		return result;
	}
}
