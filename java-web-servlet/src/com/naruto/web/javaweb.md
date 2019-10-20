## Http

 1、概念：超文本传输协议
 
 2、传输协议：定义了服务端和客户端交互时的数据格式
 
 3、特点：
 
    基于tcp/ip的高级协议
    默认端口80
    基于请求响应模型(请求响应一一对应)短连接
    无状态：每次请求时相互独立的
 
 4、历史版本：
 
    1.0 每次请求响应都会建立连接
    1.1 复用链接
 
 5、请求消息数据格式和响应消息数据格式
 
    (1)、请求消息的数据格式
        请求行  
            请求方式 URL 协议及版本        GET /javaweb/servlet01 HTTP/1.1    
        请求头
            host:请求主机
            user-agent:浏览器信息
            accept:
            accept-language:
            accept-encoding:
            connection:
        空行
        请求体(请求正文)
            get:方法没有请求体
            post:
                userName=naruto&password=123456
        
    (2)、响应消息的数据格式
    
        响应行
            协议及版本 状态码 状态码描述     HTTP/1.1 200 OK
            状态码：服务器告诉浏览器这次相应的状态
                1xx:服务器接受客户端消息但是没有接受完，等待一会时间后，发送该状态码
                2xx:成功 200
                3xx:重定向 302(重定向) 304(访问缓存)
                4xx:客户端错误
                5xx:服务器错误
                
        响应头
            Content-Type:服务器告诉浏览器响应体数据格式以编码格式 
            Content-disposition:服务器告诉浏览器以什么格式打开响应体数据
        空行
        响应体:响应的数据信息
 ## Request vs Response
 6、Request
    
    (1)原理：
    
        当服务器接收到浏览器的请求后，会解析URL,获取资源路径,在查找web.xml中配置的servlet全类名；
        servlet容器将对应servlet的字节码文件加载到内存，根据全类名，反射创建对象，并初始化；
        servlet容器将请求信息封装为ServletRequest接口的实例对象，创建ServletResponse接口的实例对象
        将ServletRequest接口的实例对象和ServletResponse接口的实例对象，作为实参传入service()方法，并调用service(),处理请求(ServletRequest)，并设置响应信息（ServletResponse）；
    
    (2)request的体系结构：
        
        ServletRequest 接口
                | 继承
        HttpServletRequest 接口
                |实现
        org.apache.catalina.connector.RequestFacade 类(tomcat创) 
    
    (3)request的功能
        获取请求消息数据
            请求行
                getMethod()
                getContextPath()
                getServletUrl()
                getQueryString()
                getRequestURI()
                getRequestURL()
                getProtocol()
                getRemoteAddr()
            请求头
                getHeader()
                getHeaderNames()            
            请求体
                getReader()
                getInputStream()
        其他功能
            获取请求参数
                getParameter()
                getParameterValues()
                getParameterNames()
                getParameterMap()
            请求转发
                request.getRequestDispatcher("/***").forword(req,resp);
                    浏览器地址栏不发生变化
                    转发只能转发当前服务器的内部资源
                    只发一次请求(可以使用request域对象中的共享数据)
            共享数据
                域对象：一个有作用范围的对象，可以在范围内共享数据
                request作用于对象：在一次请求范围，一般用于请求转发的多个资源内共享数据
                setAttribute()
                getAttribute()
                removeAttribute()
            获取ServletContext
                getServletContext()
            设置编码
                setCharacterEncoding()
 7、Response
 
    (1)、体系结构
        ServletResponse
                |
        HttpServletResponse
                |
        org.apache.catalina.connector.ResponseFacade 类(tomcat创)
    
    (2)、Response功能：设置响应消息
    
        设置响应行
            setStatus()
        设置响应头
            setHeader()
        设置响应体
            获取输出流
            使用输出流，将数据输出到哭护短
            getWriter()
            getOutputStream()
        重定向：
            sendRedirect()
                地址栏发生不变
                可以访问其他服务器的资源
                发送两次请求(不能使用request域对象中的共享数据)
        字符编码：
            setContentType()            
 8、ServletContext
    
    (1)概念：代表整个web应用，web上下文
    (2)获取：
        request.getServletContext()
        HttpServlet  this.getServletContext()
    (3)功能：
        获取MIME类型(网络通信中定义的一种文件数据类型)
            getMimeType()
        域对象：
            setAttribute()
            getAttribute()
            removeAttribute()
        获取文件的真实路径：
            getRealPath()   
 
## 会话技术
   
 9、会话
  
    (1)会话：一次会话包含多次的请求与响应，
    (2)一次会话的生命周期：一次会话浏览器第一次给服务器发送请求，会话就建立，直到一方断开为止，会话结束
    (3)会话的功能：在一次会话的生命周期内的多次请求间共享数据；
    (4)分类：客户端会话技术和服务器端会话技术
    
 10、Cookie
    
    (1)概念：客户端会话技术，将数据保存到客户端
    (2)快速入门
        创建Cookie,绑定数据
        发送Cookie到客户端
        获取Cookie,拿到数据
    
    (3)cookie原理
        在一次回话工程中，浏览器第一次访问服务器，服务器创建cookie并在cookie中保存数据(new Cookie(k,v))，
        然后随响应信息一起返回给浏览器(resp.addCookies(new Cookie(k,v))，响应头中set-cookie的信息)
        在该回话过程中，浏览器再发送请求时，会带着该Cookie(作为请求头cookie中的信息）访问服务器，服务器可以获取该Cookie信息
    
    
        
    
    
    
    
     
    
    
