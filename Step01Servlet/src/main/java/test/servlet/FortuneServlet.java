package test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1,2,3의 형식을 맞추어서 작성해야한다  **
//3.어떤 경로 요청을 처리할것인지 경로 설정 (반드시 /로 시작해야한다) 
@WebServlet("/fortune") //이런 요청을 최초처리할때 new가 되는것_  한번만 생성 !
public class FortuneServlet extends HttpServlet{	//1.HttpServlet 클래스 상속
	//2. service () 메소드 오버라이드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//여기에 필요한 객체가 생성되면서 참조값(요청과 응답)이 알아서 전달이 된다!
		//이 안에 우리가 필요한 내용을 코딩하면 된다 !
		
		//응답 인코딩 설정
		resp.setCharacterEncoding("utf-8");
		//응답 컨텐트 설정
		resp.setContentType("text/html; charset=utf-8");
		
		//클라이언트에게 문자열을 응답할수 있는 객체의 참조값 얻어내기
		PrintWriter pw=resp.getWriter();
		pw.println("<!docutype html>");
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<meta charset=utf-8>");
		pw.println("<title>오늘의 운세 페이지</title>");
		pw.println("</head>");
		pw.println("<body>");
		//오늘의 운세 5개를 미리 준비해둔다.
		
		String[] fortunes={"동쪽으로 가면 귀인을 만나요",
				"오늘은 집에만 계세요",
				"너무 멀리가지 마세요",
				"오늘은 뭘해되 되는 날이에요",
				"로또 당첨!!"
		};
		Random ran = new Random();
		int ranNum = ran.nextInt(5);
			
		pw.println("<p> " + fortunes[ranNum] + "</p>");
		pw.println("</body>");
		pw.println("</html>");
		pw.close();
	}
	//
}
