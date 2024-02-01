<#-- @ftlvariable name="targetLogin" type="java.lang.String" -->
<#-- @ftlvariable name="text" type="java.lang.String" -->
<#-- @ftlvariable name="error" type="java.lang.String" -->
<#-- @ftlvariable name="message" type="ru.itmo.wp.model.domain.Talk" -->
<#-- @ftlvariable name="messages" type="ru.itmo.wp.model.domain.Talk[]" -->
<#-- @ftlvariable name="user" type="ru.itmo.wp.model.domain.User" -->
<#-- @ftlvariable name="users" type="ru.itmo.wp.model.domain.User[]" -->
<#import "commons.ftlh" as c>
<@c.page>
    <div class="form-box">
        <div class="header">Send a message</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="sendMessage"/>
                <div class="field">
                    <div class="name">
                        <label for="targetLogin">To</label>
                    </div>
                    <div class="value">

                        <select id="targetLogin" name="targetLogin">
                            <#list users as user>
                                <option value="${user.login}">${user.login}</option>
                            </#list>
                        </select>

                    </div>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="text">Text</label>
                    </div>
                    <div class="value">
                        <textarea id="text" name="text"><#if text??>${text!}</#if></textarea>
                    </div>
                </div>
                <#if error??>
                    <div class="error">
                        ${error!}
                    </div>
                </#if>
                <div class="button-field">
                    <input type="submit" value="Send Message">
                </div>
            </form>
        </div>
    </div>

    <#--
    <#list messages as message>
            <p>id: ${message.id}</p>
            <p>sourceUserId: ${message.sourceUserId}</p>
            <p>targetUserId: ${message.targetUserId}</p>
            <p>text: ${message.text}</p>
            <p>creationTime: ${message.creationTime}</p>
    </#list>
    -->

    <div class="datatable" style="margin-top: 10px">
        <div class="caption">Messages</div>
        <table>
            <thead>
            <tr>
                <th>Id</th>
                <th>Source User ID</th>
                <th>Target User ID</th>
                <th>Text</th>
                <th>Creation Time</th>
            </tr>
            </thead>
            <tbody>
            <#list messages as message>
                <tr>
                    <td>${message.id}</td>
                    <td>${message.sourceUserId}</td>
                    <td>${message.targetUserId}</td>
                    <td>${message.text}</td>
                    <td>${message.creationTime}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    </div>
</@c.page>