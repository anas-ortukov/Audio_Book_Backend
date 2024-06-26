document.getElementById('loginForm').addEventListener('submit', function (event) {
    event.preventDefault();

    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    axios({
        url: 'http://localhost:8080/api/auth/login',
        method: 'POST',
        data: {
            email: email, password: password
        }
    })
        .then(response => {

            console.log(response.data)
            localStorage.setItem('token', response.data.token)
            localStorage.setItem('refreshToken', response.data.refreshToken)
            window.location.href = 'admin.html';
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Email or Password is wrong, please try again');
        });
});