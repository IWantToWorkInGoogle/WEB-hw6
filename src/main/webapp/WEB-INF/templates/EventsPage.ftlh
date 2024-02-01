<#-- @ftlvariable name="event" type="ru.itmo.wp.model.domain.Event"  -->
<#-- @ftlvariable name="events" type="ru.itmo.wp.model.domain.Event[]"  -->

<#import "commons.ftlh" as c>
<@c.page>
    <div class="datatable">
        <div class="caption">User</div>
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>User ID</th>
                <th>Type</th>
                <th>Creation Time</th>
            </tr>
            </thead>
            <tbody>
            <#if events??>
                <#list events as event>
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.userId}</td>
                        <td>${event.type}</td>
                        <td>${event.creationTime}</td>
                    </tr>
                </#list>
            </#if>
            </tbody>
        </table>
    </div>
</@c.page>