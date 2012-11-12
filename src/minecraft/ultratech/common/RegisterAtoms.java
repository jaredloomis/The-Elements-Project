package ultratech.common;
import ultratech.api.matter.AtomLibrary;

public class RegisterAtoms 
{	
	public static void init()
	{
		AtomLibrary l = new AtomLibrary();
		
		l.registerAtom(RegisterBlocks.one, 1, 1, 1);
		l.registerAtom(RegisterBlocks.two, 2, 2, 2);
		l.registerAtom(RegisterBlocks.three, 3, 3, 3);
		l.registerAtom(RegisterBlocks.four, 4, 4, 4);
		l.registerAtom(RegisterBlocks.five, 5, 5, 5);
		l.registerAtom(RegisterBlocks.six, 6, 6, 6);
		l.registerAtom(RegisterBlocks.seven, 7, 7, 7);
		l.registerAtom(RegisterBlocks.eight, 8, 8, 8);
		l.registerAtom(RegisterBlocks.nine, 9, 9, 9);
		l.registerAtom(RegisterBlocks.ten, 10, 10, 10);
		l.registerAtom(RegisterBlocks.eleven, 11, 11, 11);
		l.registerAtom(RegisterBlocks.twelve, 12, 12, 12);
		l.registerAtom(RegisterBlocks.twentyNine, 29, 29, 29);
	}
}
