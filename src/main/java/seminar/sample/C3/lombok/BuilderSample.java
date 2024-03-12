package seminar.sample.C3.lombok;

import lombok.Builder;

@Builder
public class BuilderSample {

	private final String url;

	private final int port;

	private final String user;

	private final String password;

	public static void main(String[] args) {

		BuilderSample builderSample = 
				BuilderSample.builder().url("jdbc:mysql").user("mysql").password("pass").build();

	}
}
