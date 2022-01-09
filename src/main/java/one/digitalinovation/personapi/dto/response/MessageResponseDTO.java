package one.digitalinovation.personapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDTO {
	
	private String message;

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
