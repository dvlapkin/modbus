import java.util.*;


public class ModBus04{
	public static void main(String[] args)
	{
		System.out.println("ModBus master:");
		ModBusRequest mbRequest = new ModBusRequest();
		ModBusRequest mbResponse = new ModBusRequest();


		mbRequest.setAdress((short)0x12).setFunctionCode((byte)0x04);
		mbResponse = mbRequest.sendRequest();
	}
}

class ModBusRequest{	
	private short adress = 0x01;
	// PDU
	private byte functionCode = 0x00;
	private short startingAddress = 0x0000;
	private short quantityOfInputRegisters = 0x0001;
	// **PDU
	private short crc = 0x0;

	public ModBusRequest setAdress(short a){
		this.adress = a;
		return this;
	}
	public ModBusRequest setFunctionCode(byte c){
		this.functionCode = c;
		return this;
	}
	public ModBusRequest setStartingAddress(short a){
		this.startingAddress = a;
		return this;
	}
	public ModBusRequest setQuantityOfInputRegisters(short q){
		this.quantityOfInputRegisters = q;
		return this;
	}

	public ModBusResponse sendRequest(){
		ModBusResponse resp = new ModBusResponse();
		return resp;
	}

	public void printRequest(){
		System.out.println("Adress: 0x"+Integer.toHexString(this.adress));
		System.out.println("Function Code: 0x"+Integer.toHexString(this.functionCode));
	}

}


class ModBusResponse{	
	private short adress = 0;
	//PDU
	private byte functionCode = 0;
	private byte byteCount = 0;
	private short[] inputRegisters;
	//**PDU

	public void printResponse(){
		System.out.println("Adress:"+this.adress);
		System.out.println("Function Code:"+this.functionCode);
		System.out.println("Function Code:"+this.functionCode);
		System.out.println("Function Code:"+this.functionCode);
	}

}