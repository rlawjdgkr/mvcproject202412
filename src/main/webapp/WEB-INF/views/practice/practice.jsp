<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .del-btn {
            padding: 5px 10px;
            outline: none;
            border: none;
            background: red;
            border-radius: 10px;
            color: #fff;
            margin-left: 10px;
            margin-bottom: 10px;
            cursor: pointer;
        }
        .del-btn:hover {
            border: 1px solid orange;
            opacity: 0.8;
        }
    </style>
</head>
<body>
<h1>MVC 댄서 정보 목록</h1>
<ul id="dancer-list">

</ul>

<a href="/mvc/v1/register">다시 등록하기</a>
<script>



    function renderPracticeList(data){
     const $dancerList  = document.getElementById('dancer-list');
     data.forEach(({id,name,age}) =>{
          $dancerList.innerHTML += `
            <li data-id ="\${id}">
           # 아이디: <span class="dancer-name">\${id}</span>,
        # 이름: \${name},
        # 나이: \${age}
        <button class="del-btn">삭제하기</button>
          </li>`
     });
     }
     // 회원 삭제 이벤트
    const $delBtn = document.getElementById('dancer-list');
    $delBtn.addEventListener('click', (e) =>{
       if(e.target.classList.contains('del-btn')){
           const $li = e.target.closest('li'); // 삭제 버튼의 부모 <li>를 찾음
           const id = $li.dataset.id; // <li>의 data-id 값 가져오기
           console.log('삭제요청 아이디 : ' , id);
         getDelete(id);
       $li.remove();
       }
    });

    // 회원 삭제 정보 요청
    async function getDelete(id){
        const res =  await fetch(`/api/v1/practice/\${id}` , {method: 'DELETE'});
        if(res.ok){
            console.log('삭제성공')








        }
    }


    async function getApi(){
        const res = await fetch("/api/v1/practice");
        const data = await res.json();

        // 화면에 정보 랜더링
        renderPracticeList(data);
    }



    // 실행 코드
    getApi();

</script>
</body>
</html>