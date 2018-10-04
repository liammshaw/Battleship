
public class BattleShip
	{
		private int size; 
		private int row;
		private String name;
		public BattleShip(int a, String b, int r){
			size = a;
			name = b;
			row = r;
		}
		public int getRow()
			{
				return row;
			}
		public void setRow(int row)
			{
				this.row = row;
			}
		public int getSize()
			{
				return size;
			}
		public void setSize(int size)
			{
				this.size = size;
			}
		public String getName()
			{
				return name;
			}
		public void setName(String name)
			{
				this.name = name;
			}
		
	}
