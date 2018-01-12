public class SampleIterator{
	


	int i;

	public SampleIterator(){
		i=0;
	}

	public String next(){
	 return this.strings[i++];
	}

	public boolean hasNext(){
		return this.string.length;
	}
}