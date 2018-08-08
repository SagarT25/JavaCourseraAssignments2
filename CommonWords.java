
/**
 * Count common words in Shakespeare's works
 * 
 * @author Duke Software Team
 * @version 1.0
 */
import edu.duke.*;

public class CommonWords
{
    // return an array of common words in English from a file
	public String[] getCommon(){
		FileResource resource = new FileResource("textfilesdata/common.txt");
		//String[] common = new String[20];
		int arraylength = 1;
		for (String s: resource.words()) {
			arraylength += 1;
		}
		System.out.println("arraylength = " + arraylength);
		String[] common = new String[arraylength-1];
		int index = 0;
		for(String s : resource.words()){
			common[index] = s;
			index += 1;
			//System.out.println("index = " + index + " word is = "+s +" and length of word is "+s.length());
		}
		return common;
	}

	// return the index of word found in the arraylist
	public int indexOf(String[] list, String word) {
	    for (int k=0; k<list.length; k++) {
	        if (list[k].equals(word)) {
	               return k;
	           }
	       }
	    return -1;
	}
	
	// Count the common words from a list of common words found in a file 
	public void countWords(FileResource resource, String[] common, int[] counts){
		for(String word : resource.words()){
			word = word.toLowerCase();
			int index = indexOf(common,word);
			if (index != -1) {
				counts[index] += 1;
			}
		}
	}
	void countShakespeare(){
		//String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
			//          "likeit.txt", "macbeth.txt", "romeo.txt"};
	    String[] plays = {"small.txt"};
		// common words array
	    String[] common = getCommon();
		//prepare an integer array to hold the count with the same length as common words array
		int[] counts = new int[common.length];
		//for(int k=0; k < counts.length; k++){
		//    System.out.println("counts before running countWords " + counts[k]);
		//}
		for(int k=0; k < plays.length; k++){
			FileResource resource = new FileResource("textfilesdata/" + plays[k]);			
			countWords(resource,common,counts);
			System.out.println("done with " + plays[k]);
		}
		
		for(int k=0; k < common.length; k++){
			System.out.println(common[k] + "\t" + counts[k]);
		}
	}
    public static void main(String args[]) {
    	CommonWords cw = new CommonWords();
    	cw.countShakespeare();
    }  	
}
