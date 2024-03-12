package seminar.sample.C3.lombok;

import java.io.File;
import java.nio.file.Files;

import lombok.Lombok;
import lombok.SneakyThrows;

public class SneakyThrowsSample {

	@SneakyThrows
	public byte[] readFile() {// 通常はIOExceptionをthrow節に書く必要がある
		File file = new File("my.txt");
		return Files.readAllBytes(file.toPath());
	}

	public static void main(String[] args) {
		new SneakyThrowsSample().readFile();
	}
}
