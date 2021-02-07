var $tableBody;
var $createUserBtn;
var $updateUserBtn;
var $editUserBtn;
var $validationMsg;
var $usernameFld;
var $firstNameFld;
var $lastNameFld;
var $passwordFld;
var $roleFld;
var users;
var userService = new AdminUserServiceClient();

function createUser() {
  if(emptyFields()) {
    invalidFeedback()
    return
  }

  var newUser = {
    username: $usernameFld.val(),
    firstName: $firstNameFld.val(),
    lastName: $lastNameFld.val(),
    password: $passwordFld.val(),
    role: $roleFld.val()
  }
  userService.createUser(newUser).then(function(userData) {
    if(userData) {
      users.push(userData)
      resetFields()
      renderUsers(users)
      validFeedback()
    } else {
      errorFeedback()
    }
    
  })
}

var selectedUser = null
function editUser (event) {
  var userId = $(event.target).attr("id")
  selectedUser = users.find(user => user._id === userId)
  if(selectedUser) {
    fillFields(selectedUser)
  } else {
    errorFeedback()
  }
}

function updateUser() {
  if (emptyFields()) {
    invalidFeedback()
    return
  }

  selectedUser.username = $usernameFld.val();
  selectedUser.firstName = $firstNameFld.val();
  selectedUser.lastName = $lastNameFld.val();
  selectedUser.password = $passwordFld.val();
  selectedUser.role = $roleFld.val()
  

  userService.updateUser(selectedUser._id, selectedUser)
  .then(function (status) {
    if (status) {
      var index = users.findIndex(user => user._id === selectedUser._id)
      users[index] = selectedUser
      resetFields()
      renderUsers(users)
      validFeedback()
    } else {
      errorFeedback()
    }

  })
}

function deleteUser(event) {
  var index = $(event.target).attr("id")
  var userId = users[index]._id
  userService.deleteUser(userId).then(function (status) {
    users.splice(index, 1)
    renderUsers(users)
  })
}

function emptyFields() {
  $('.paqc-input').each(function () {
    if (($(this).val() === "") || ($('.paqc-input').has('option').length === 0)) {
      return true;
    }
  })
  return false
}

function fillFields (user) {
  $usernameFld.val(user.username);
  $firstNameFld.val(user.firstName);
  $lastNameFld.val(user.lastName);
  $passwordFld.val(user.password);
  $roleFld.val(user.role);
}

function resetFields() {
  $usernameFld.val("");
  $firstNameFld.val("");
  $lastNameFld.val("");
  $passwordFld.val("");
  $roleFld.val("");
}

function invalidFeedback() {
  $validationMsg.empty()
  $validationMsg.prepend(`
    <div class="paqc-validation-message col-12 alert alert-danger">
      Please complete all the inputs.
    </div>`)
  setTimeout(function () {
    $validationMsg.empty();
  }, 4000);
}

function validFeedback() {
  $validationMsg.empty()
  $validationMsg.prepend(`
    <div class="paqc-validation-message col-12 alert alert-success">
      User created successfully.
    </div>`)
  setTimeout(function () {
    $validationMsg.empty();
  }, 4000);
}

function errorFeedback() {
  $validationMsg.empty()
  $validationMsg.prepend(`
    <div class="paqc-validation-message col-12 alert alert-danger">
      Error: Something went wrong.
    </div>`)
  setTimeout(function () {
    $validationMsg.empty();
  }, 4000);
}
function renderUsers(usersArray) {
  $tableBody.empty()
  for (var i = 0; i < usersArray.length; i++) {
    var user = usersArray[i];
    $tableBody.prepend(` 
			<div class="paqc-table-row">
        <div class="col-6 paqc-col-md-2-2">
          <div class="row">
            <span class="paqc-table-hidden-element">
              Username:&nbsp;&nbsp;
            </span>
            ${user.username}
          </div>
        </div>
        <div class="col-6 paqc-col-md-2-2">
          <div class="row">
            <span class="paqc-table-hidden-element">
              First Name:&nbsp;&nbsp;
            </span>
            ${user.firstName}
          </div>
        </div>
        <div class="col-6 paqc-col-md-2-2">
          <div class="row">
            <span class="paqc-table-hidden-element">
              Last Name:&nbsp;&nbsp;
            </span>
            ${user.lastName}
          </div>
        </div>
        <div class="col-6 paqc-col-md-2-2">
          <div class="row">
            <span class="paqc-table-hidden-element">
              Password:&nbsp;&nbsp;
            </span>
            ${user.password}
          </div>
        </div>
        <div class="col-6 paqc-col-md-2-2">
          <div class="row">
            <span class="paqc-table-hidden-element">
              Role:&nbsp;&nbsp;
            </span>
            ${user.role}
          </div>
        </div>
        <div class="paqc-table-hidden-element p-2">&nbsp;</div>
        <div class="wbdv-actions col-12 col-md-1">
          <div class="paqc-centered-container">
            <div class="paqc-icon paqc-icon-btn-teal col">
              <a class="paqc-delete-user-btn">
                <i class="fa fa-times fa-lg wbdv-remove" id="${i}"></i>
                <span class="paqc-table-hidden-element">
                  Delete User
                </span>
              </a>
            </div>
            <div class="paqc-icon paqc-icon-btn-dark col">
              <a class="paqc-edit-user-btn">
                <i class="fa fa-pencil fa-lg wbdv-edit" id="${user._id}"></i>
                <span class="paqc-table-hidden-element">
                  Edit User
                </span>
              </a>
            </div>
          </div>
        </div>
      </div>`)
  }
  $('.paqc-delete-user-btn').click(deleteUser)
  $('.paqc-edit-user-btn').click(editUser)
}

function main() {
  $tableBody = $('.paqc-table-body');
  $createUserBtn = $('.paqc-create-user-btn')
  $updateUserBtn = $('.paqc-update-user-btn')
  $validationMsg = $('.paqc-validation-message')
  $usernameFld = $('.paqc-username-fld')
  $firstNameFld = $('.paqc-firstname-fld')
  $lastNameFld = $('.paqc-lastname-fld')
  $passwordFld = $('.paqc-password-fld')
  $roleFld = $('.paqc-role-fld')

  $createUserBtn.click(createUser)
  $updateUserBtn.click(updateUser)

  userService.findAllUsers().then(function(usersData) {
    users = usersData
    renderUsers(users)
  })
}
$(main)