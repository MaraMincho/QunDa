package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.*;

import java.io.IOException;
import java.util.List;

@WebServlet("*.do")
public class professorController extends HttpServlet {
    Professor professor;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        String uri = req.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));
        System.out.println("요청 path : " + path);

        if (path.equals("/signup.do")) {
            System.out.println("회원가입");
            // 사용자 입력정보 추출
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String pw = req.getParameter("password1");
            String postion = req.getParameter("position");
            System.out.println(postion);

            // DB 연동 처리
            ProfessorDAO dao = new ProfessorDAO();
            dao.InsertPROFESSOR(name, email, pw, postion);
            req.setAttribute("name", name); //알아서 ㅇㅇ

            RequestDispatcher dispatcher = req.getRequestDispatcher("/view/LoginScreen.jsp");
            System.out.println("로그인 기능 처리 완료");
            dispatcher.forward(req, resp);
        }

        else if (path.equals("/InsertRoom.do")) {
            System.out.println("글 추가");

            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String position = req.getParameter("postion");
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("position", position);

            String SubjectName = req.getParameter("SunName");
            String Time = req.getParameter("Time");
            String Roomnum = req.getParameter("Roomnum");
            String body = req.getParameter("body");
            req.setAttribute("Time", Time);
            req.setAttribute("Roomnum", Roomnum);
            req.setAttribute("subName", SubjectName);

            RoomDAO dao = new RoomDAO();
            dao.InesrtRoom(Roomnum, body);
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/view/Room.do");
            dispatcher.forward(req, resp);
        }


        else if (path.equals("/Room.do")) {
            System.out.println("Room조회");


            // 사용자 입력정보 추출
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String position = req.getParameter("postion");

            String Time = req.getParameter("Time");
            String Roomnum = req.getParameter("Roomnum");
            String SubName = req.getParameter("SubName");
            Professor user = new Professor();
            user.setName(email);
            user.setId(email);
            user.setName(name);
            System.out.println(email);

            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("position", position);

            System.out.println(Roomnum);
            req.setAttribute("Time", Time);
            req.setAttribute("Roomnum", Roomnum);
            req.setAttribute("subName", SubName);
            req.setAttribute("user", user);

            RoomDAO dao = new RoomDAO();
            List<Room>list1 = dao.InfoRoomList(Roomnum);
            req.setAttribute("list", list1);

            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/view/Room.jsp");
            dispatcher.forward(req, resp);

        }


        else if (path.equals("/insertBoard.do")) {
            System.out.println("교수 교과목 추가");

            // 사용자 입력정보 추출
            String email = req.getParameter("email");
            String name = req.getParameter("name");
            String position = req.getParameter("postion");
            req.setAttribute("name", name);
            req.setAttribute("email", email);
            req.setAttribute("position", position);

            String SubjectName = req.getParameter("SubjectName");
            String Time = req.getParameter("Time");
            String RoomNum = req.getParameter("RoomNum");
            ProfessorBoardListDAO dao = new ProfessorBoardListDAO();
            dao.InsertPROFESSOR_board_list(email, SubjectName, Time, RoomNum);


            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/view/Professor_mainpage.do");
            dispatcher.forward(req, resp);

        }





        else if (path.equals("/Professor_mainpage.do")) {
            System.out.println("보드리스트");

            // 사용자 입력정보 추출
            String email = req.getParameter("email");

            ProfessorBoardListDAO dao = new ProfessorBoardListDAO();
            List<ProfessorBoardList>list1 = dao.InfoBoardlist(email);

//            req.setAttribute("time1", list1.get(0).getTime());
//            req.setAttribute("time2", list1.get(1).getTime());
//            req.setAttribute("SubName1", list1.get(0).getSubjectName());
//            req.setAttribute("SubName2", list1.get(1).getSubjectName());
//            req.setAttribute("RoomNum1", list1.get(0).getRoomNum());
//            req.setAttribute("RoomNUm2", list1.get(1).getRoomNum());

            req.setAttribute("boardList", list1);
            RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/view/Professor_mainpage.jsp");
            dispatcher.forward(req, resp);
        }


        else if (path.equals("/login.do")) {
            System.out.println("로그인 기능 처리");
            // 사용자 입력정보 추출
            String id = req.getParameter("email");
            String password = req.getParameter("pw");
            System.out.println(id);

            // DB 연동 처리
            Professor pfVo = new Professor();
            pfVo.setId(id);

            ProfessorDAO pfDAO = new ProfessorDAO();
            Professor User = pfDAO.getProfssor(pfVo);

            // 화면 이동
            if (User != null) {
                if (User.getPw().equals(password)) {
                    System.out.println("로그인 햇음!");
                    // 상태 정보를 세션에 저장
                    req.setAttribute("name", User.getName());
                    req.setAttribute("email", User.getId());
                    req.setAttribute("position", User.getPosition());

                    RequestDispatcher dispatcher = getServletConfig().getServletContext().getRequestDispatcher("/view/Professor_mainpage.do");
                    dispatcher.forward(req, resp);
                }else {
                    RequestDispatcher dispatcher = req.getRequestDispatcher("/view/LoginScreen.jsp");
                    dispatcher.forward(req, resp);
                }
            }
            else{
                RequestDispatcher dispatcher = req.getRequestDispatcher("/view/LoginScreen.jsp");
                dispatcher.forward(req, resp);
            }
        }


    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("두포 식ㄹ행");
        doGet(request,response);
    }

}
