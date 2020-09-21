<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%> 

<div class="modal fade" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="modalDeleteLabel" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered">
    <div class="modal-content" style="color: black !important;">
    
       <div class="modal-header">
        <h5 class="modal-title" id="modalDeleteLabel">Potwierdzenie</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      
     	<div class="modal-body">
        	<p>Czy na pewno chcesz usunąć?</p>
     	</div>
      
     <div class="modal-footer">
        <button type="button" id="btnCancel" class="btn btn-secondary" data-dismiss="modal">Anuluj</button>
        <a id="btnDelete" class="btn myButton" >Usuń</a>
      </div>
      
    </div>
  </div>
</div>