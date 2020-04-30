package swexpert_복습;
import java.util.ArrayList;
import java.util.Arrays;

//아리토스테네스의체
//인덱스를 값으로
//boolean으로 그 값이 소수인지 아닌지 여부.

//아이디어
// 1을 제외한 모든 수를 소수로 가정하고 boolean배열을 전부 true로 초기화하고
// 2~100000까지의 각각의 숫자들의 배수들은 소수가 아니기때문에 false처리한다.
// 여기서 이미 false처리된 숫자들은 다시 false처리 해줄 필요가 없기때문에
// if문을 통해 그 숫자가 소수인지 아닌지 미리 판별한다.

public class Solution_d3_100만이하의모든소수 {

	static boolean[] arr = new boolean[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuilder sb = new StringBuilder();
		
		Arrays.fill(arr, true);
		
		arr[1] = false;
		
		for (int i = 2; i < 1000000; i++) {
			
			if( arr[i] == true) {
				for (int j = 2; j*i < 1000000; j++) {
						arr[i*j] = false;						
				}				
			}
		
		}
		
		for (int i = 2; i < 1000000; i++) {
			if(arr[i] == true) {
				sb.append(i+" ");
			}
		}
		
		System.out.println(sb);
	}

}