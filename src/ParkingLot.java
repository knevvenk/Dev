import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
		
	//Status
	//CreateSlots
	//Allocate Slot for parking
	//leave
	//getRegistrationByColor
	//getSlotNumbersByColor
	//getSlotNumbersByRegNumber
	
	int SLOTS_SIZE = 0;
	
	static List<String> availableParkingSlots;
	Map<String, List<String>> regNumbersByColor = new HashMap<String, List<String>>();
	Map<String, String> slotFromRegNumber  = new HashMap<String, String>();
	
	public static void main(String[] args){
		
	}
}
