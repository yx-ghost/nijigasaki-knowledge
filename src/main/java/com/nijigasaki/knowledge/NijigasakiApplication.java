package com.nijigasaki.knowledge;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@SpringBootApplication
public class NijigasakiApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(NijigasakiApplication.class);
		app.setBanner((environment, sourceClass, out) -> {
			Resource resource = new ClassPathResource("yao.jpg"); // 动漫图片的文件路径
			BufferedImage image = null;
			try {
				image = ImageIO.read(resource.getInputStream());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			int width = image.getWidth();
			int height = image.getHeight();
			int scale = 10; // 压缩比例，可以根据需要调整
			int compressedWidth = width / scale;
			int compressedHeight = height / scale;
			StringBuilder sb = new StringBuilder();
			for (int y = 0; y < compressedHeight; y += 2) {
				for (int x = 0; x < compressedWidth; x++) {
					Color color = new Color(image.getRGB(x * scale, y * scale));
					sb.append(getColorCode(color));
				}
				sb.append(System.lineSeparator());
			}
			out.print(sb.toString());
		});
		app.setBannerMode(Banner.Mode.CONSOLE);
		app.run(args);
	}

	private static String getColorCode(Color color) {
		int r = color.getRed();
		int g = color.getGreen();
		int b = color.getBlue();
		return String.format("\u001B[48;2;%d;%d;%dm \u001B[0m", r, g, b);
	}

}
