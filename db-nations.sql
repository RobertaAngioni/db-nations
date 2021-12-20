

select c.name as country_name, c.country_id, r.name as region_name, c2.name as continent_name 
from countries c 
join regions r on c.region_id = r.region_id 
join continents c2 on c2.continent_id = r.continent_id 
order by c.name;