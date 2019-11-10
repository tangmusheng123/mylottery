// //查询结果
// function inquire(type) {
//     if ($('#inp').val() == '') {
//         return
//     }
//     console.log('window.localStorage.isDiai', window.localStorage.isDiai);
//     let inquireParams = {
//             target: $('#inp').val(),
//             platformType: window.localStorage.isDiai == true ? 'diai' : 'kub'
//         }
//         // 领取后新请求
//     if (type == 'getAll') {
//         inquireParams = JSON.parse(window.localStorage.inquireParams)
//     }
//     console.log('inquireParams', inquireParams);

//     $.ajax({
//         type: 'post',
//         url: inquireUrl,
//         data: inquireParams,
//         dataType: 'json',
//         success: function(res) {
//             if (res.code == 200) {
//                 let data = res.data
//                 console.log('res.data', data);
//                 if (data.length === 0) {
//                     console.log('datafff', data);

//                 } else {
//                     // 重新赋值新数据且保留查询条件
//                     window.localStorage.dataList = ''
//                     window.localStorage.dataList = JSON.stringify(data)
//                     window.localStorage.inquireParams = ''
//                     window.localStorage.inquireParams = JSON.stringify(inquireParams)
//                     self.location = 'detail.html';
//                 }

//             }
//         },
//         error: function(msg) {
//             console.log(msg)
//         }
//     })

// }
// 浏览器窗口大小变化时
// $(window).resize(function() {
//     var window_width = $(window).width(); //获取浏览器窗口宽度

//     if (window_width > 750) {
//         window.location.reload()
//     }
//     if (window_width < 750) {
//         window.location.reload()
//     }

// });